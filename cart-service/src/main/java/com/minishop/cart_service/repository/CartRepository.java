package com.minishop.cart_service.repository;

import com.minishop.cart_service.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
