package com.papertrading.trading_server.dto.response;

import java.time.Instant;

import com.papertrading.trading_server.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private Instant createdAt;

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt())
            .build();
    }
}
