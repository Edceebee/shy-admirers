package com.aksh.shyadmirer.service.impl;

import com.aksh.shyadmirer.dto.request.AuthRequest;
import com.aksh.shyadmirer.dto.response.AuthResponse;
import com.aksh.shyadmirer.repository.AppUserRepository;
import com.aksh.shyadmirer.security.JwtService;
import com.aksh.shyadmirer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AppUserRepository userRepository;

    // Method to authenticate the user and generate a token
    public AuthResponse authenticate(AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = (UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}
