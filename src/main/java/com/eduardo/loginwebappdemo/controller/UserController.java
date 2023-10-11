package com.eduardo.loginwebappdemo.controller;

import com.eduardo.loginwebappdemo.auth.CurrentUser;
import com.eduardo.loginwebappdemo.exception.ResourceNotFoundException;
import com.eduardo.loginwebappdemo.model.entities.User;
import com.eduardo.loginwebappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser User userPrincipal){
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
