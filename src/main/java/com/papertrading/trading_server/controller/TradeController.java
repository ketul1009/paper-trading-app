package com.papertrading.trading_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.papertrading.trading_server.dto.request.CreateTradeRequest;
import com.papertrading.trading_server.dto.response.TradeResponse;
import com.papertrading.trading_server.service.TradeService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/v1/trades")
@RequiredArgsConstructor
public class TradeController {
    
    private final TradeService tradeService;

    @PostMapping()
    public ResponseEntity<TradeResponse> createTrade(@RequestBody CreateTradeRequest request) {
        TradeResponse tradeResponse = tradeService.createTrade(request);
        return new ResponseEntity<>(tradeResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<TradeResponse> getTrade(@RequestParam Long id) {
        TradeResponse tradeResponse = tradeService.getTrade(id);
        return new ResponseEntity<>(tradeResponse, HttpStatus.OK);
    }
}
