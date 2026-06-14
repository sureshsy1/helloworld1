package com.example.helloworld1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private helloworld2ServiceWebClient helloworld2ServiceWebClient;
    @GetMapping("/")
    public String hello() {
        String response = helloworld2ServiceWebClient.get()
            .uri("/hello")
            .retrieve()
            .bodyToMono(String.class)
            .block(); // Waits synchronously until the response arrives

        System.out.println("Response from helloworld2-service: " + response);
        return response;
    }
}
