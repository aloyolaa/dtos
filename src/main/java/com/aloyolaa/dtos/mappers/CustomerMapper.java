package com.aloyolaa.dtos.mappers;

import com.aloyolaa.dtos.dtos.CustomerDetailDto;
import com.aloyolaa.dtos.dtos.CustomerDto;
import com.aloyolaa.dtos.entities.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);

    Customer toEntity(CustomerDetailDto customerDetailDto);

    CustomerDetailDto toCustomerDetailDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate1(CustomerDetailDto customerDetailDto, @MappingTarget Customer customer);

    @AfterMapping
    default void linkInvoices(@MappingTarget Customer customer) {
        customer.getInvoices().forEach(invoice -> invoice.setCustomer(customer));
    }
}