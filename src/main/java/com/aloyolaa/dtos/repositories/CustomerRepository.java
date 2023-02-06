package com.aloyolaa.dtos.repositories;

import com.aloyolaa.dtos.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}