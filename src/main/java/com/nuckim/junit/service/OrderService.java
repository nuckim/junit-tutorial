package com.nuckim.junit.service;

import com.nuckim.junit.dto.OrderDTO;
import com.nuckim.junit.entity.OrderDetail;
import com.nuckim.junit.entity.OrderHistory;
import com.nuckim.junit.entity.OrderMaster;
import com.nuckim.junit.repository.mongodb.OrderHistoryDAO;
import com.nuckim.junit.repository.postgresql.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderHistoryDAO orderHistoryDAO;
    private final OrderMapper orderMapper;

    public OrderMaster orderProcess(OrderDTO.Request request) {
        // OrderMaster에 주문 등록
        OrderMaster orderMaster = OrderMaster.builder()
                .userId(request.getUserId())
                .build();
        orderMapper.insertOrderMaster(orderMaster);

        // OrderDetail에 상세 주문 목록 등록
        List<OrderDetail> orderList = new ArrayList<>();
        request.getOrderInfoList().forEach(item -> orderList.add(OrderDetail.builder()
                .product(item.getProduct())
                .amt(item.getProduct().getSalePrice() * item.getCount())
                .orderMasterId(orderMaster.getOrderMasterId())
                .build()));
        orderMapper.insertOrderDetailList(orderList);

        // mongodb OrderHistory에 통계 정보 등록
        Double totalAmt = orderList.stream().mapToDouble(OrderDetail::getAmt).sum();
        OrderHistory history = OrderHistory.builder()
                .totalAmt(totalAmt)
                .orderMasterId(orderMaster.getOrderMasterId())
                .userId(orderMaster.getUserId())
                .build();
        orderHistoryDAO.insertHistory(history);
        return orderMaster;
    }
}
