package com.epam.tickerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @GetMapping(value = "/greet")
    public String greet() {
        return "Hello ";
    }
}
