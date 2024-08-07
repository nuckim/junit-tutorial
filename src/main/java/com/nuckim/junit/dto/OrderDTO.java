package com.nuckim.junit.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class OrderDTO {
    @Getter
    @Builder
    public static class Request {
        private List<OrderInfo> orderInfoList;
        private Long userId;
    }
}


