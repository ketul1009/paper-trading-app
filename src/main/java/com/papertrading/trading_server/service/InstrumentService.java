package com.papertrading.trading_server.service;

import org.springframework.data.domain.Pageable;

import com.papertrading.trading_server.dto.request.CreateInstrumentRequest;
import com.papertrading.trading_server.dto.response.InstrumentResponse;
import com.papertrading.trading_server.dto.response.PagedResponse;

public interface InstrumentService {
    public InstrumentResponse createInstrument(CreateInstrumentRequest request);
    public InstrumentResponse getInstrumentBySymbol(String symbol);
    public PagedResponse<InstrumentResponse> getAllInstruments(Pageable pageable);
}
