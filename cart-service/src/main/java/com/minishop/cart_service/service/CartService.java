package com.minishop.cart_service.service;

import com.minishop.cart_service.dto.ProductCartDto;
import com.minishop.cart_service.model.CartEntity;
import com.minishop.cart_service.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartEntity> getAll() {
        return cartRepository.findAll();
    }

    @Transactional
    public boolean addProductsToCart(List<ProductCartDto> productCartDtos) {
        List<CartEntity> cartEntities = productCartDtos
                .stream()
                .map(productCartDto -> {
                    CartEntity cartEntity = new CartEntity();
                    cartEntity.setProductId(productCartDto.getProductId());
                    cartEntity.setQuantity(productCartDto.getQuantity());
                    cartEntity.setPrice(productCartDto.getPrice());
                    return cartEntity;
                })
                .collect(Collectors.toList());

        try {
            cartRepository.saveAll(cartEntities);
            return true;
        } catch (Exception e) {
            log.error("exception when saving list cart: ", e);
            return false;
        }

    }
}
