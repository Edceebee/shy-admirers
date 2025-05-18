package com.aksh.shyadmirer.controller;

import com.aksh.shyadmirer.dto.request.AuthRequest;
import com.aksh.shyadmirer.dto.request.CreateUserDto;
import com.aksh.shyadmirer.dto.response.AuthResponse;
import com.aksh.shyadmirer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDto userDto) {
        return ResponseEntity.ok(authService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
