package com.nuckim.junit.repository.postgresql;

import com.nuckim.junit.entity.OrderDetail;
import com.nuckim.junit.entity.OrderMaster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertOrderMaster(OrderMaster orderMaster);

    void insertOrderDetailList(List<OrderDetail> orderDetailList);
}
