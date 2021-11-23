package com.example.dockertest.repository;

import com.example.dockertest.model.User;
import org.springframework.stereotype.Repository;

public interface UserDao {
    public User save(User user);

    public User get(Long id);
}
