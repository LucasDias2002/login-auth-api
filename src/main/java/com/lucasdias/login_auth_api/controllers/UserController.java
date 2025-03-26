package com.lucasdias.login_auth_api.controllers;

import com.lucasdias.login_auth_api.dto.UsersDTO;
import com.lucasdias.login_auth_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity list(){
        return ResponseEntity.ok(repository.findAll().stream()
                .map(user -> new UsersDTO(user.getId(), user.getName(), user.getEmail())));
    }
}
