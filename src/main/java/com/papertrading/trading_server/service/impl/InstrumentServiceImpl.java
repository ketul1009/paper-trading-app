package com.papertrading.trading_server.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.papertrading.trading_server.dto.request.CreateInstrumentRequest;
import com.papertrading.trading_server.dto.response.InstrumentResponse;
import com.papertrading.trading_server.entity.Instrument;
import com.papertrading.trading_server.repository.InstrumentRepository;
import com.papertrading.trading_server.service.InstrumentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService{
    
    private final InstrumentRepository instrumentRepository;

    // TODO: Use only while testing
    @Transactional
    @Override
    public InstrumentResponse createInstrument(CreateInstrumentRequest request) {
        if (instrumentRepository.existsBySymbol(request.getSymbol())){
            throw new IllegalArgumentException("Symbol " + request.getSymbol() + " already exists");
        }
        Instrument instrument = Instrument.builder()
            .name(request.getName())
            .symbol(request.getSymbol())
            .exchange(request.getExchange())
            .type(request.getType())
            .build();
        
        Instrument savedInstrument = instrumentRepository.save(instrument);
        return InstrumentResponse.fromEntity(savedInstrument);
    }

    @Override
    public InstrumentResponse getInstrumentBySymbol(String symbol) {
        Instrument instrument = instrumentRepository.findBySymbol(symbol)
            .orElseThrow(() -> new IllegalArgumentException("Instrument with symbol " + symbol + " not found"));
        return InstrumentResponse.fromEntity(instrument);
    }
}
