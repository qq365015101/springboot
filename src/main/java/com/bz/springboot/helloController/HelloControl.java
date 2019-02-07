package com.bz.springboot.helloController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
