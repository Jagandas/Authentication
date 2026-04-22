package com.example.loginproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;   // ✅ IMPORTANT
import org.springframework.web.bind.annotation.*;

import com.example.loginproject.model.User;
import com.example.loginproject.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {

        service.saveUser(user);
        model.addAttribute("msg", "Registered Successfully!");

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = service.login(username, password);

        if (user != null) {
            return "home";
        } else {
            model.addAttribute("msg", "Invalid Credentials!");
            return "login";
        }
    }
}