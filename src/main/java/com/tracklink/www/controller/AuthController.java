package com.tracklink.www.controller;

import com.tracklink.www.dto.UserLoginDto;
import com.tracklink.www.dto.UserRegisterDto;
import com.tracklink.www.model.User;
import com.tracklink.www.service.AuthService;
import com.tracklink.www.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracklink/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<User>> registerUser (@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully registered user!!!", this.authService.registerUser(userRegisterDto)));
    }

    @PostMapping("/login-user")
    public ResponseEntity<ApiResponse<String>> loginUser (@RequestBody UserLoginDto userLoginDto) {
        return this.authService.loginUser(userLoginDto);
    }
}
