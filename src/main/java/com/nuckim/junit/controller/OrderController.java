package com.nuckim.junit.controller;

import com.nuckim.junit.dto.OrderDTO;
import com.nuckim.junit.entity.OrderMaster;
import com.nuckim.junit.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderMaster> doOrder(@RequestBody OrderDTO.Request request) {
        return ResponseEntity.ok(orderService.orderProcess(request));
    }
}
