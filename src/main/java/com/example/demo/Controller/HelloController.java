package com.example.demo.Controller;

import com.example.demo.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String sayHello() {
        return greetingService.getGreeting();
    }
}
