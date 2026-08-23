package com.papertrading.trading_server.service.impl;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.papertrading.trading_server.dto.request.CloseTradeRequest;
import com.papertrading.trading_server.dto.request.CreateTradeRequest;
import com.papertrading.trading_server.dto.response.TradeResponse;
import com.papertrading.trading_server.entity.Instrument;
import com.papertrading.trading_server.entity.Trade;
import com.papertrading.trading_server.entity.User;
import com.papertrading.trading_server.entity.enums.TradeStatus;
import com.papertrading.trading_server.repository.InstrumentRepository;
import com.papertrading.trading_server.repository.TradeRepository;
import com.papertrading.trading_server.repository.UserRepository;
import com.papertrading.trading_server.service.TradeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {
    
    private final TradeRepository tradeRepository;
    private final UserRepository userRepository;
    private final InstrumentRepository instrumentRepository;

    @Override
    @Transactional
    public TradeResponse createTrade(CreateTradeRequest request) {
        User user = userRepository.findById(request.getUser_id())
            .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
    
        Instrument instrument = instrumentRepository.findById(request.getInstrument_id())
            .orElseThrow(() -> new IllegalArgumentException("Instrument does not exist"));

        Trade trade = Trade.builder()
            .user(user)
            .instrument(instrument)
            .purchage_price(request.getPurchase_price())
            .quantity(request.getQuantity())
            .selling_price(null)
            .status(TradeStatus.OPEN)
            .build();
        
        Trade savedTrade = tradeRepository.save(trade);
        
        return TradeResponse.fromEntity(savedTrade);
    }

    @Override
    public TradeResponse getTrade(Long id) {
        Trade trade = tradeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Trade with id " + id + " does not exist"));
        
        return TradeResponse.fromEntity(trade);
    }

    @Override
    public TradeResponse closeTrade(Long id, CloseTradeRequest request) {
        Trade trade = tradeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Trade with id " + id + " does not exist"));
        
        trade.setSelling_price(request.getSelling_price());
        trade.setClosed_at(Instant.now());
        trade.setStatus(TradeStatus.CLOSED);
        tradeRepository.save(trade);
        return TradeResponse.fromEntity(trade);
    }
}
