package com.minishop.product_service.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minishop.product_service.dto.ProductCartDto;
import com.minishop.product_service.exception.ProductNotFoundException;
import com.minishop.product_service.model.ProductEntity;
import com.minishop.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/v1/products")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductEntity>> allProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductEntity> productByCode(@PathVariable String code) {
        return productService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductNotFoundException("Product with code [" + code + "] doesn't exist"));
    }

    /**
     * [
     *   {
     *     "productId": 1,
     *     "quantity": 3
     *   },
     *   {
     *     "productId": 3,
     *     "quantity": 4
     *   }
     * ]
     * **/
    @PostMapping("/addCart")
    public ResponseEntity<Boolean> addToCart(@RequestBody List<ProductCartDto> productCartDtos) {
        boolean isSuccess = productService.addToCart(productCartDtos);
        return ResponseEntity.ok(isSuccess);
    }
}
