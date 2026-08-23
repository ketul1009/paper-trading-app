package com.papertrading.trading_server.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CloseTradeRequest {
    
    @NotBlank()
    private BigDecimal selling_price;

}
