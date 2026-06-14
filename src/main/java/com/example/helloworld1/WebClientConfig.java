package com.example.helloworld1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${helloworld2-service.url}")
    private String helloworld2ServiceUrl;

    @Bean(name = "helloworld2ServiceWebClient")
    public WebClient helloworld2ServiceWebClient() {
        return WebClient.builder()
                .baseUrl(helloworld2ServiceUrl) // Will resolve to http://helloworld2-service:8080
                .build();
    }
}