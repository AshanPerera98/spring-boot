package com.ashan_perera.content_calendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // this will try to read the env variable and if its not available it will be default to the given value
    @Value("${env.message: Default welcome message}")
    private String message;

    @GetMapping("/")
    public String home(){
        return message;
    }
    
}
