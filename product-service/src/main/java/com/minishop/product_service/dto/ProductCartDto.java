package com.minishop.product_service.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductCartDto {

    private Long productId;
    @NotBlank
    private String productCode;
    @Min(0)
    private int quantity;

    private double price;

}
