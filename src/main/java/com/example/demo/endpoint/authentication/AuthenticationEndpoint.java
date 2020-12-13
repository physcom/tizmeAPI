package com.example.demo.endpoint.authentication;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.auth.AuthenticatedUserDto;

public interface AuthenticationEndpoint {
    AuthenticatedUserDto authenticate(AuthenticationRequestDto requestDto);
    AuthenticatedUserDto register(UserRegisterDto userRegisterDto);
}
