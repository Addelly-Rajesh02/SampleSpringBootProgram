package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Value("${app.message:Default Message}")
    private String message;

    @Bean
    public CommandLineRunner runner() {
        return args -> System.out.println("App Message: " + message);
    }
}
