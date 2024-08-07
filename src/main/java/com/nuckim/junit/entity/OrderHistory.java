package com.nuckim.junit.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderHistory {
    private Long orderMasterId;
    private Long userId;
    private Double totalAmt;
}
