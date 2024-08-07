package com.nuckim.junit.service;

import com.nuckim.junit.dto.ProductDTO;
import com.nuckim.junit.entity.Product;
import com.nuckim.junit.repository.postgresql.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public Product saveProduct(ProductDTO.Request request) {
        Product product = request.convert();
        productMapper.insertProduct(product);
        return product;
    }
}
