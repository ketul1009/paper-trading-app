package com.papertrading.trading_server.entity;

import lombok.*;
import jakarta.persistence.*;
import com.papertrading.trading_server.entity.enums.InstrumentType;

@Entity
@Table(name = "instruments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String symbol;

    @Column(nullable = false)
    private String exchange;

    @Column(nullable = false)
    private InstrumentType type;
}