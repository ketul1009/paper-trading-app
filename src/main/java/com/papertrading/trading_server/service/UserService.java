package com.papertrading.trading_server.service;

import com.papertrading.trading_server.dto.request.CreateUserRequest;
import com.papertrading.trading_server.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    UserResponse getUserByEmail(String email);
    UserResponse getUserById(Long id);
}