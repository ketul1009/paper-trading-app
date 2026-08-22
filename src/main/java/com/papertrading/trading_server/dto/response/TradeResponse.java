package com.papertrading.trading_server.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

import com.papertrading.trading_server.entity.Trade;
import com.papertrading.trading_server.entity.enums.TradeStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeResponse {
    private Long id;
    private Long user_id;
    private Long instrument_id;
    private BigDecimal purchase_price;
    private BigDecimal selling_price;
    private TradeStatus status;
    private Instant created_at;
    private Instant closed_at;

    public static TradeResponse fromEntity(Trade trade) {
        return TradeResponse.builder()
            .id(trade.getId())
            .user_id(trade.getUser().getId())
            .instrument_id(trade.getInstrument().getId())
            .purchase_price(trade.getPurchage_price())
            .selling_price(trade.getSelling_price())
            .status(trade.getStatus())
            .created_at(trade.getCreated_at())
            .closed_at(trade.getClosed_at())
            .build();

    }
}
