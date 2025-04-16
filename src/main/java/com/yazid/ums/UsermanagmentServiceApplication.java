package com.yazid.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that boots up the Spring Boot application.
 * This is the entry point when the app starts.
 */
@SpringBootApplication
public class UsermanagmentServiceApplication {

    /**
     * Main method used to launch the Spring Boot app.
     * SpringApplication.run starts the embedded server.
     */
    public static void main(String[] args) {
        SpringApplication.run(UsermanagmentServiceApplication.class, args);
    }

}
