package com.minishop.cart_service.web;

import com.minishop.cart_service.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/carts")
public class CartAPI {

    @Autowired
    private CartRepository cartRepository;



}
