package com.papertrading.trading_server.dto.response;

import com.papertrading.trading_server.entity.Instrument;
import com.papertrading.trading_server.entity.enums.InstrumentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstrumentResponse {
    private Long id;
    private String name;
    private String symbol;
    private String exchange;
    private InstrumentType type;

    public static InstrumentResponse fromEntity(Instrument instrument){
        return InstrumentResponse.builder()
            .id(instrument.getId())
            .name(instrument.getName())
            .symbol(instrument.getSymbol())
            .exchange(instrument.getExchange())
            .type(instrument.getType())
            .build();
    }
}
