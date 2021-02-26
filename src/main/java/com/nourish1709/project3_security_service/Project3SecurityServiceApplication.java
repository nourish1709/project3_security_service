package com.nourish1709.project3_security_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Project3SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Project3SecurityServiceApplication.class, args);
    }

}
