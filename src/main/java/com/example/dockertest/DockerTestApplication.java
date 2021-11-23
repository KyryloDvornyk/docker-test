package com.example.dockertest;

import com.example.dockertest.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerTestApplication {
    public static void main(String[] args) {
        System.out.println("Test main");
        SpringApplication.run(DockerTestApplication.class, args);
        System.out.println("Test main");
    }
}
