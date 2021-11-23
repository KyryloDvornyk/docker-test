package com.example.dockertest.service;

import com.example.dockertest.model.User;

public interface UserService {
    public User save();

    public User get(Long id);
}
