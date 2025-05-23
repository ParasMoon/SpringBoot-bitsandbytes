package com.bitsandbytes.product.controller;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "App is working!";
    }
}
