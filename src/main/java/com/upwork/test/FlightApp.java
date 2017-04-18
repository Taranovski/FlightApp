package com.upwork.test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Titan on 18.04.2017.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.upwork.test")
public class FlightApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FlightApp.class, args);
    }
}