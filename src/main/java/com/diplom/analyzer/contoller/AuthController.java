package com.diplom.analyzer.contoller;

import com.diplom.analyzer.dto.request.AuthRequest;
import com.diplom.analyzer.dto.response.AuthResponse;
import com.diplom.analyzer.service.auth.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(path = "/api/auth")
public class AuthController {

    AuthService authService;

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> registration(@RequestBody AuthRequest request) {

        log.info("Начинаю регистриацию пользователя {}",request.getUsername());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.registration(request));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        log.info("Пытаюсь войти под пользователем {}",request.getEmail());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.login(request));
    }

    @PostMapping(path = "/out")
    public ResponseEntity<Void> logout() {

        log.info("Выполняю выход");

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
