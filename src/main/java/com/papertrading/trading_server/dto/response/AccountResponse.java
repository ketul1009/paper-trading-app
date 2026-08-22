package com.papertrading.trading_server.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

import com.papertrading.trading_server.entity.Account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {
    private Long id;
    private Long user_id;
    private BigDecimal cash_balance;
    private Instant created_at;

    public static AccountResponse fromEntity(Account account){
        return AccountResponse.builder()
            .id(account.getId())
            .user_id(account.getUser().getId())
            .cash_balance(account.getCashBalance())
            .created_at(account.getCreatedAt())
            .build();
    }
}
