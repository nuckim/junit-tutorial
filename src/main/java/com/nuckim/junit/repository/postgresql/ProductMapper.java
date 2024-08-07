package com.nuckim.junit.repository.postgresql;

import com.nuckim.junit.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void insertProduct(Product product);
}
