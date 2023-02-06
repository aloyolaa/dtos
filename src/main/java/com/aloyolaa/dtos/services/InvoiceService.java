package com.aloyolaa.dtos.services;

import com.aloyolaa.dtos.dtos.InvoiceDetailDto;
import com.aloyolaa.dtos.dtos.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDetailDto> findAll();

    InvoiceDetailDto findById(Long id);

    InvoiceDetailDto save(InvoiceDto invoiceDto);

    InvoiceDetailDto update(InvoiceDto invoiceDto);

    Boolean delete(Long id);
}
