package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author demo
 */
@RestController
public class AppController {

    @Value("${demo.one}")
    private String one;

    @GetMapping(value = "/one")
    public String one() {
        return this.one;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "helloworld";
    }
}
