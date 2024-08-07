package com.nuckim.junit.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderMaster {
    private Long orderMasterId;
    private Long userId;
}
