package com.example.helloworld1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HelloController {

@Autowired
    @Qualifier("helloworld2ServiceWebClient")
    private WebClient webClient;

    @GetMapping("/")
    public String hello() {
        String response = webClient.get()
            .uri("/")
            .retrieve()
            .bodyToMono(String.class)
            .block(); // Waits synchronously until the response arrives

        System.out.println("Response from helloworld2-service: " + response);
        return response;
    }
}
