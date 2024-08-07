package com.nuckim.junit.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long userId;
    private String userName;
    private String userEmail;
}
