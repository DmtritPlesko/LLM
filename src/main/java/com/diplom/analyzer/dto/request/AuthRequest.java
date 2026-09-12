package com.diplom.analyzer.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {

    @Size(min = 5, max = 10, message = "5 < username < 10")
    String username;

    @Size(min = 5,max = 50,message = "Email is very short")
    String email;

    @Size(min = 6, max = 32, message = "6 < password < 32")
    String password;
}
