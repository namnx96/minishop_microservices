package com.minishop.cart_service.web;

import com.minishop.cart_service.dto.ProductCartDto;
import com.minishop.cart_service.model.CartEntity;
import com.minishop.cart_service.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/carts")
public class CartAPI {

    @Autowired
    private CartService cartService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Greeting from cart-service");
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addProducts(@RequestBody List<ProductCartDto> productCartDtos) {
        boolean isSuccess = cartService.addProductsToCart(productCartDtos);
        return ResponseEntity.ok(isSuccess);
    }

    @GetMapping("")
    public ResponseEntity<Collection<CartEntity>> getAll() {
        return ResponseEntity.ok(cartService.getAll());
    }

}
