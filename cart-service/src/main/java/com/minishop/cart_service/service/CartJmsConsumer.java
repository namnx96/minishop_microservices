package com.minishop.cart_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minishop.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartJmsConsumer {

//    @Autowired
//    CartRepository cartRepository;
//
//    @JmsListener(destination = "${product.jms.destination}")
//    public void consumeMessage(String data)  {
//
//        try {
//
//            ObjectMapper mapper = new ObjectMapper();
//            //Json data to Product object
//            Product product = mapper.readValue(data,Product.class);
//            productRepository.save(product);
//
//        } catch (JsonProcessingException e){
//            e.getStackTrace();
//        }
//    }
}
