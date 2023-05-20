package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
@EntityScan("com.*")
@EnableFeignClients
public class moduleTwo {
    public static void main(String... args) {
        SpringApplication.run(moduleTwo.class, args);
    }
}
