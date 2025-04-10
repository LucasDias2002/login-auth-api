package com.lucasdias.login_auth_api.controllers;

import com.lucasdias.login_auth_api.domain.user.User;
import com.lucasdias.login_auth_api.dto.LoginRequestDTO;
import com.lucasdias.login_auth_api.dto.RegisterDTO;
import com.lucasdias.login_auth_api.dto.ResponseDTO;
import com.lucasdias.login_auth_api.infra.security.TokenService;
import com.lucasdias.login_auth_api.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new UsernameNotFoundException("Email or password invalid"));

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.genereteToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        } else {
            throw new RuntimeException("Email or password invalid");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterDTO body) {
        Optional<User> user = repository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));

            this.repository.save(newUser);

            String token = this.tokenService.genereteToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        else{
            throw new RuntimeException("Email unavailable");
        }
    }
}