package com.nuckim.junit.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.nuckim.junit.config.properties.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClientService(MongoProperties mongoProperties) {
        MongoCredential credential = MongoCredential.createCredential(mongoProperties.getUsername(),
                mongoProperties.getAuthDatabase(), mongoProperties.getPassword().toCharArray());
        MongoClientSettings settings = MongoClientSettings.builder().credential(credential)
                .applyToClusterSettings(builder -> builder
                        .hosts(List.of(new ServerAddress(mongoProperties.getServiceHost(), mongoProperties.getPort()))))
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate serviceTemplate(MongoClient mongoClientService) {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClientService, "Service");
        ((MappingMongoConverter) mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));
        return mongoTemplate;
    }
}
