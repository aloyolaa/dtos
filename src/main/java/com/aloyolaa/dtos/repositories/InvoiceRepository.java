package com.aloyolaa.dtos.repositories;

import com.aloyolaa.dtos.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}