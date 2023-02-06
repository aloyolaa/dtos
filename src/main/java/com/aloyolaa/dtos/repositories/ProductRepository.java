package com.aloyolaa.dtos.repositories;

import com.aloyolaa.dtos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}