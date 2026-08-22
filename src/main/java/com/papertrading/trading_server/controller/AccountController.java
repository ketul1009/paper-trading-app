package com.papertrading.trading_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.papertrading.trading_server.dto.response.AccountResponse;
import com.papertrading.trading_server.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    
    @GetMapping
    public ResponseEntity<AccountResponse> getAccountById(@RequestParam Long id){
        AccountResponse accountResponse = accountService.getAccountById(id);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
}
