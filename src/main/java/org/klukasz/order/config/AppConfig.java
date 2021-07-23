package org.klukasz.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${order-service.customer-service.url}")
    private String customerServiceUrl;

    @Bean
    public RestTemplate customerService(RestTemplateBuilder builder) {
        return builder.rootUri(customerServiceUrl)
                .build();
    }
}
