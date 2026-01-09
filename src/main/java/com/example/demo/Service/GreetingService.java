package com.example.demo.Service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String getGreeting() {
        return "Hello Iam Service Class!";
    }
}
