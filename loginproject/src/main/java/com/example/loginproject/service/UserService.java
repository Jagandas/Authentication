package com.example.loginproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginproject.model.User;
import com.example.loginproject.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Register
    public User saveUser(User user) {
        return repo.save(user);
    }

    // Login check
    public User login(String email, String password) {
        User user = repo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}