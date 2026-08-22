package com.papertrading.trading_server.dto.request;

import com.papertrading.trading_server.entity.enums.InstrumentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateInstrumentRequest {
    
    @NotBlank(message = "symbol is required")
    private String symbol;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "exchange is required")
    private String exchange;

    @NotNull(message = "type is required")
    private InstrumentType type;
}
