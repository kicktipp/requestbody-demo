package com.example.requestbodydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SpringBootApplication
@RestController
public class RequestbodyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestbodyDemoApplication.class, args);
    }

    @PostMapping("/form")
    public Answer post(@Valid @RequestBody Form form, BindingResult bindingResult) {
        return new Answer(bindingResult.getErrorCount());
    }
}
