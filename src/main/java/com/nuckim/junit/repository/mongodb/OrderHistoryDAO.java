package com.nuckim.junit.repository.mongodb;

import com.nuckim.junit.entity.OrderHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderHistoryDAO {
    private static final String ORDER_HISTORY = "OrderHistory";
    private final MongoTemplate serviceTemplate;

    public OrderHistory insertHistory(OrderHistory orderHistory) {
        return serviceTemplate.insert(orderHistory, ORDER_HISTORY);
    }
}
