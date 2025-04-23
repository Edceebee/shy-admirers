package com.aksh.shyadmirer.service;

import com.aksh.shyadmirer.dto.request.AuthRequest;
import com.aksh.shyadmirer.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest request);

}
