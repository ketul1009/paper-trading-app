package com.papertrading.trading_server.service;

import com.papertrading.trading_server.dto.request.CreateInstrumentRequest;
import com.papertrading.trading_server.dto.response.InstrumentResponse;

public interface InstrumentService {
    public InstrumentResponse createInstrument(CreateInstrumentRequest request);
    public InstrumentResponse getInstrumentBySymbol(String symbol);
}
