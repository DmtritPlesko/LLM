package com.diplom.analyzer.service.auth;

import com.diplom.analyzer.dto.request.AuthRequest;
import com.diplom.analyzer.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse registration(AuthRequest authRequest);

    AuthResponse login(AuthRequest authRequest);

    void logout();
}
