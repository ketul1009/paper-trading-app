package com.papertrading.trading_server.service;

import com.papertrading.trading_server.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse getAccountById(Long id);
}
