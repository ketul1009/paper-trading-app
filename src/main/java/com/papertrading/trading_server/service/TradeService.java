package com.papertrading.trading_server.service;

import com.papertrading.trading_server.dto.request.CreateTradeRequest;
import com.papertrading.trading_server.dto.response.TradeResponse;

public interface TradeService {
    public TradeResponse createTrade(CreateTradeRequest request);
    public TradeResponse getTrade(Long id);
}
