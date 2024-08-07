package com.nuckim.junit.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetail {
    private Long orderDetailId;
    private Long orderMasterId;
    private Product product;
    private Double amt;
}
