package com.aloyolaa.dtos.mappers;

import com.aloyolaa.dtos.dtos.ProductDto;
import com.aloyolaa.dtos.entities.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);

    ProductDto toProductDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);
}