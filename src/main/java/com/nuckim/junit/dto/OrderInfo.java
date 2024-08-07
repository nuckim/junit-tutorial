package com.nuckim.junit.dto;

import com.nuckim.junit.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderInfo {
    private Product product;
    private int count;
}
