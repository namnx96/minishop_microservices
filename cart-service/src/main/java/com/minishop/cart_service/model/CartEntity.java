package com.minishop.cart_service.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    private int quantity;

    private double price;
    @Transient
    private String productName;
}
