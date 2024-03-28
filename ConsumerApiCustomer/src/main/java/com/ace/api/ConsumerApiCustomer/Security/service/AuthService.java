package com.ace.api.ConsumerApiCustomer.Security.service;

import com.ace.api.ConsumerApiCustomer.Security.model.Role;
import com.ace.api.ConsumerApiCustomer.Security.model.User;
import com.ace.api.ConsumerApiCustomer.Security.payload.AuthResponse;
import com.ace.api.ConsumerApiCustomer.Security.payload.LoginRequest;
import com.ace.api.ConsumerApiCustomer.Security.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login (LoginRequest loginRequest){
        return null;
    }
    public AuthResponse register (RegisterRequest registerRequest){
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .lastName(registerRequest.getLastName())
                .firstName(registerRequest.getFirstName())
                .country(registerRequest.getCountry())
                .role(Role.USER).build();

        return AuthResponse.builder()
                .token(jwtService.getToken(user)).build();
    }
}
