package com.aloyolaa.dtos.services;

import com.aloyolaa.dtos.dtos.ProductDto;
import com.aloyolaa.dtos.entities.Product;
import com.aloyolaa.dtos.mappers.ProductMapper;
import com.aloyolaa.dtos.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDto)
                .toList();
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toProductDto(productRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if (productDto.id() == null) {
            throw new IllegalArgumentException();
        }
        Product product = productRepository.findById(productDto.id()).orElseThrow(EntityNotFoundException::new);
        Product updateProduct = productMapper.partialUpdate(productDto, product);
        return productMapper.toProductDto(productRepository.save(updateProduct));
    }

    @Override
    public Boolean delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        productRepository.deleteById(id);
        return true;
    }
}
