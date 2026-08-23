package com.papertrading.trading_server.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.papertrading.trading_server.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    Optional<Trade> findById(Long id);

    List<Trade> findByUserId(Long id);
}
