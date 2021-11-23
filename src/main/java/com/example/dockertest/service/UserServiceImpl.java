package com.example.dockertest.service;

import com.example.dockertest.model.User;
import com.example.dockertest.repository.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save() {
        User user = new User();
        user.setName("Bob");
        return userDao.save(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }
}
