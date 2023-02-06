package com.aloyolaa.dtos.services;

import com.aloyolaa.dtos.dtos.CustomerDetailDto;
import com.aloyolaa.dtos.dtos.CustomerDto;
import com.aloyolaa.dtos.entities.Customer;
import com.aloyolaa.dtos.mappers.CustomerMapper;
import com.aloyolaa.dtos.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDetailDto findById(Long id) {
        return customerMapper.toCustomerDetailDto(customerRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    @Override
    @Transactional
    public CustomerDto update(CustomerDto customerDto) {
        if (customerDto.id() == null) {
            throw new IllegalArgumentException();
        }
        Customer customer = customerRepository.findById(customerDto.id()).orElseThrow(EntityNotFoundException::new);
        Customer updateCustomer = customerMapper.partialUpdate(customerDto, customer);
        return customerMapper.toCustomerDto(customerRepository.save(updateCustomer));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        customerRepository.deleteById(id);
        return true;
    }
}
