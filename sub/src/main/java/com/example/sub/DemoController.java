package com.example.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author asus
 */
@RestController
public class DemoController {

    @Value("${demo.two}")
    private String two;

    @Value("${demo.three}")
    private String three;

    @Autowired
    private Environment env;

    @GetMapping(value = "/two/")
    public String two() {
        return this.two;
    }

    @GetMapping(value = "/three/")
    public String three() {
        return this.three;
    }

    @GetMapping(value = "/four/")
    public String four() {
        return env.getProperty("demo.four") + "...";
    }
}
