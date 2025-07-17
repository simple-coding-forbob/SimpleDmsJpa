package com.simplecoding.simpledms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleDmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleDmsApplication.class, args);
    }

}
