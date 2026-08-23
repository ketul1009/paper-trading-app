package com.papertrading.trading_server.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.papertrading.trading_server.entity.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    
    Optional<Instrument> findBySymbol(String symbol);

    boolean existsBySymbol(String symbol);

    Page<Instrument> findAll(Pageable pageable);
}