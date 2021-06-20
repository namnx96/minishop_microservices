package com.minishop.product_service.service;

import com.minishop.product_service.dto.ProductCartDto;
import com.minishop.product_service.model.ProductEntity;
import com.minishop.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<ProductEntity> findAllProducts() {
        return productRepo.findAll();
    }

    public Optional<ProductEntity> findByCode(String code) {
        return productRepo.findByCode(code);
    }

    public ProductEntity save(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }

    public boolean addToCart(List<ProductCartDto> productCartDtos) {
        List<Long> listProductId = productCartDtos
                .stream()
                .map(ProductCartDto::getProductId)
                .collect(Collectors.toList());

        Map<Long, ProductEntity> mapProductById = mapProductById(listProductId);
        List<ProductCartDto> validProductCartDtos = productCartDtos
                .stream()
                .filter(productCartDto -> mapProductById.containsKey(productCartDto.getProductId()))
                .peek(productCartDto -> {
                    ProductEntity productEntity = mapProductById.get(productCartDto.getProductId());
                    productCartDto.setPrice(productEntity.getPrice());
                })
                .collect(Collectors.toList());

//        String addToCartUrl = "http://localhost:8082/api/v1/carts/add";
        String addToCartUrl = "http://localhost:8080/api/v1/carts/add";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("ContentType", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<ProductCartDto>> request = new HttpEntity<>(validProductCartDtos, headers);
        ResponseEntity<Boolean> result = restTemplate.postForEntity(addToCartUrl, request, Boolean.class);
        return result.getStatusCode() == HttpStatus.OK;
    }

    private Map<Long, ProductEntity> mapProductById(Collection<Long> productIds) {
        return productRepo.findByIdIn(productIds)
                .stream()
                .collect(Collectors.toMap(ProductEntity::getId, Function.identity()));
    }
}
