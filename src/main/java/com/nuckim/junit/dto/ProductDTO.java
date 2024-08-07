package com.nuckim.junit.dto;

import com.nuckim.junit.entity.Product;
import lombok.Builder;
import lombok.Getter;

public class ProductDTO {
    @Getter
    @Builder
    public static class Request {
        private String productName;
        private Double price;
        private Double salePrice;

        public Product convert() {
            return Product.builder()
                    .productName(this.productName)
                    .price(this.price)
                    .salePrice(this.salePrice)
                    .build();
        }
    }
}
