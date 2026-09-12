package com.diplom.analyzer.service.auth;

import com.diplom.analyzer.dto.request.AuthRequest;
import com.diplom.analyzer.dto.response.AuthResponse;
import com.diplom.analyzer.entity.User;
import com.diplom.analyzer.mapper.AuthMapper;
import com.diplom.analyzer.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    AuthMapper mapper;

    @Override
    public AuthResponse registration(AuthRequest authRequest) {

        if (userRepository.existsByUsername(authRequest.getUsername())) {
            throw new RuntimeException("Пользователь уже в системе");
        }

        User user = User.builder()
                .username(authRequest.getUsername())
                .email(authRequest.getEmail())
                .password(authRequest.getPassword())
                .build();

        return mapper.toResponse(userRepository.save(user));
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {

        log.info("Попытка входа под {}",authRequest.getEmail());

        User user = userRepository.findByEmailIgnoreCase(authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        if (!user.getPassword().equals(authRequest.getPassword())) {
            throw new RuntimeException("Пароль не совападают");
        }

        return mapper.toResponse(user);
    }

    @Override
    public void logout() {

    }
}
