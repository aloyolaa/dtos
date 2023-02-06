package com.aloyolaa.dtos.mappers;

import com.aloyolaa.dtos.dtos.InvoiceDetailDto;
import com.aloyolaa.dtos.dtos.InvoiceDto;
import com.aloyolaa.dtos.entities.Invoice;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {InvoiceItemMapper.class, CustomerMapper.class})
public interface InvoiceMapper {
    @Mapping(source = "customerId", target = "customer.id")
    Invoice toEntity(InvoiceDto invoiceDto);

    @Mapping(source = "customer.id", target = "customerId")
    InvoiceDto toItemDto(Invoice invoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerId", target = "customer.id")
    Invoice partialUpdate(InvoiceDto invoiceDto, @MappingTarget Invoice invoice);

    Invoice toEntity(InvoiceDetailDto invoiceDetailDto);

    InvoiceDetailDto toInvoiceDetailDto(Invoice invoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Invoice partialUpdate1(InvoiceDetailDto invoiceDetailDto, @MappingTarget Invoice invoice);
}