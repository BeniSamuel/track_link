package com.tracklink.www.service;

import com.tracklink.www.dto.UserLoginDto;
import com.tracklink.www.dto.UserRegisterDto;
import com.tracklink.www.model.User;
import com.tracklink.www.util.ApiResponse;
import com.tracklink.www.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthService (AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    public User registerUser (UserRegisterDto userRegisterDto) {
        return this.userService.createUser(userRegisterDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );

            User user = this.userService.getUserByEmail(userLoginDto.getEmail());
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully logged in user!!! 🎉🎉🎉", this.jwtUtil.generateToken(user.getEmail())));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Provided bad credentials!!!", null));
        }
    }
}
