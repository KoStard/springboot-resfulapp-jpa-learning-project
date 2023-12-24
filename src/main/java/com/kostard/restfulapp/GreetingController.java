package com.kostard.restfulapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    AtomicLong atomicLong = new AtomicLong(0);

    @GetMapping("/greeting")
    public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(atomicLong.incrementAndGet(), String.format("Hello, %s", name));
    }
}
