package com.ace.api.ConsumerApiCustomer.Security.controller;

import com.ace.api.ConsumerApiCustomer.Security.payload.LoginRequest;
import com.ace.api.ConsumerApiCustomer.Security.payload.RegisterRequest;
import com.ace.api.ConsumerApiCustomer.Security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
    @PostMapping(value = "register")
    public String register(@RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(authService.register(registerRequest));
    }
}
