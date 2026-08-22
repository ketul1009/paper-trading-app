package com.papertrading.trading_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.papertrading.trading_server.dto.request.CreateUserRequest;
import com.papertrading.trading_server.dto.response.UserResponse;
import com.papertrading.trading_server.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse userResponse = userService.createUser(request);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<UserResponse> getUser(@RequestParam String email) {
        UserResponse userResponse = userService.getUserByEmail(email);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    
    
}
