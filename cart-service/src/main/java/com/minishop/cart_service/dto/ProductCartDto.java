package com.minishop.cart_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCartDto {
    private Long productId;
    private String productCode;
    private int quantity;
    private double price;

}
