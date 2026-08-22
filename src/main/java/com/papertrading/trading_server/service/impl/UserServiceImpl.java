package com.papertrading.trading_server.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.papertrading.trading_server.dto.request.CreateUserRequest;
import com.papertrading.trading_server.dto.response.UserResponse;
import com.papertrading.trading_server.entity.Account;
import com.papertrading.trading_server.entity.User;
import com.papertrading.trading_server.repository.UserRepository;
import com.papertrading.trading_server.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists");
        }

        User user = User.builder()
            .email(request.getEmail())
            .passwordHash(request.getPassword())
            .build();
        
        Account account = Account.builder()
            .user(user)
            .cashBalance(new BigDecimal("100000.00"))
            .build();

        user.setAccount(account);
        User savedUser = userRepository.save(user);
        return UserResponse.fromEntity(savedUser);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("User with email " + email + " does not exist"));
        return UserResponse.fromEntity(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " does not exist"));
        return UserResponse.fromEntity(user);
    }

}