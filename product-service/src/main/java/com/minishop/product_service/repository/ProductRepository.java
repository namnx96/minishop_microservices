package com.minishop.product_service.repository;

import com.minishop.product_service.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);
}
