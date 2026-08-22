package com.papertrading.trading_server.service.impl;

import org.springframework.stereotype.Service;

import com.papertrading.trading_server.dto.response.AccountResponse;
import com.papertrading.trading_server.entity.Account;
import com.papertrading.trading_server.repository.AccountRepository;
import com.papertrading.trading_server.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountResponse getAccountById(Long id) {
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Account with id " + id + " does not exist"));
        
        return AccountResponse.fromEntity(account);
    }
}
