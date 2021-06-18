package com.minishop.product_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minishop.product_service.dto.ProductCartDto;
import com.minishop.product_service.model.ProductEntity;
import com.minishop.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.destination.cart-product}")
    private String cartProductJmsQueue;

    public List<ProductEntity> findAllProducts() {
        return productRepo.findAll();
    }

    public Optional<ProductEntity> findByCode(String code) {
        return productRepo.findByCode(code);
    }

    public Optional<ProductCartDto> addToCart(ProductCartDto productCartDto) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            //Convert the object to String
            String jsonInString = mapper.writeValueAsString(productCartDto);
            //Send the data to the message queue
            jmsTemplate.convertAndSend(cartProductJmsQueue, jsonInString);
            return Optional.of(productCartDto);

        } catch (JsonProcessingException e) {
            log.error("exception when sending JMS to cartProductJmsQueue: ", e);
            return Optional.empty();
        }
    }
}
