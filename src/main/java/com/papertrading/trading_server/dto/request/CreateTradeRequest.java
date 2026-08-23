package com.papertrading.trading_server.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateTradeRequest {
    
    @NotNull(message = "User_id is required")
    private Long user_id;

    @NotNull(message = "instrument_id is required")
    private Long instrument_id;

    @NotNull(message = "purchase_price is required")
    @Positive(message = "purchase_price must be greater than 0")
    private BigDecimal purchase_price;

    @NotNull(message = "quantity is required")
    @Positive(message  = "quantity cannot be required")
    private BigDecimal quantity;
}
