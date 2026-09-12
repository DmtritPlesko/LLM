package com.diplom.analyzer.service.user;

import com.diplom.analyzer.entity.User;

public interface UserService {

    User findByUsername(String username);
}
