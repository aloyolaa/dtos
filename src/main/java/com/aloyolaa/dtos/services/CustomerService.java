package com.aloyolaa.dtos.services;

import com.aloyolaa.dtos.dtos.CustomerDetailDto;
import com.aloyolaa.dtos.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();

    CustomerDetailDto findById(Long id);

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);

    Boolean delete(Long id);
}
