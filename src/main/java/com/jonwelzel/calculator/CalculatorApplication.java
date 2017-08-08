package com.jonwelzel.calculator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CalculatorApplication {
    public static void main(String ... args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
