package com.minishop.product_service.repository;

import com.minishop.product_service.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);

    List<ProductEntity> findByIdIn(Collection<Long> productIds);
}
