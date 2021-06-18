package com.minishop.product_service.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;
    private String description;
    private double price;
    private int quantity;
}
