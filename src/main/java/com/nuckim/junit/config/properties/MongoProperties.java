package com.nuckim.junit.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mongodb")
@Getter
@Setter
public class MongoProperties {
    private String serviceHost;
    private int port;
    private String authDatabase;
    private String username;
    private String password;
}
