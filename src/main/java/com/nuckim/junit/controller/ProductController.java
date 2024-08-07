package com.nuckim.junit.controller;

import com.nuckim.junit.dto.ProductDTO;
import com.nuckim.junit.entity.Product;
import com.nuckim.junit.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO.Request request) {
        Product result = productService.saveProduct(request);
        return ResponseEntity.ok(result);
    }
}
