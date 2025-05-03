package com.tracklink.www.controller;

import com.tracklink.www.model.User;
import com.tracklink.www.service.UserService;
import com.tracklink.www.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracklink/v1/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ResponseEntity.ok().body(new ApiResponse<>(true, "Successfully retrieved users!!!", this.userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById (@PathVariable Long id) {
        User user = this.userService.getUserById(id);
        return user != null
                ?
                ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained user!!! 🎉🎉🎉", this.userService.getUserById(id)))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to retrieve user!!!", this.userService.getUserById(id)));
    }
}
