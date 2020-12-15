package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class HelloWorldController {

    @GetMapping("hello")
    public String sayHello(){
        return "Hello world";
    }


    @GetMapping("hi")
    public String sayHi(){
        return "Hello world hi";
    }

}
