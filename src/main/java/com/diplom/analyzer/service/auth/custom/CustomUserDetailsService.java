package com.diplom.analyzer.service.auth.custom;

import com.diplom.analyzer.entity.User;
import com.diplom.analyzer.service.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomUserDetailsService implements UserDetailsService {

    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Поиск пользователя: {}", username);

        User user = userService.findByUsername(username);

        log.info("Пользователь найден: {}, ID: {}", user.getUsername(), user.getUuid());

        return new CustomUserDetails(
                user.getUuid(),
                user.getUsername(),
                user.getPassword()
        );
    }
}

