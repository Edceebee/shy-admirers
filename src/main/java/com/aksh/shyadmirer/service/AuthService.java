package com.aksh.shyadmirer.service;

import com.aksh.shyadmirer.dto.request.AuthRequest;
import com.aksh.shyadmirer.dto.request.CreateUserDto;
import com.aksh.shyadmirer.dto.response.AuthResponse;

public interface AuthService {

    Object register(CreateUserDto userDto);

    AuthResponse login(AuthRequest request);

}
