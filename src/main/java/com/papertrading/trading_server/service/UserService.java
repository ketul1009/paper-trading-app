package com.papertrading.trading_server.service;

import com.papertrading.trading_server.dto.request.CreateUserRequest;
import com.papertrading.trading_server.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    // UserResponse getUser(Long id);
}