package com.example.dockertest.controller;

import com.example.dockertest.model.User;
import com.example.dockertest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("/create-user")
    public User save(){
        return userService.save();
    }
}
