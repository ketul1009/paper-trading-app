package com.papertrading.trading_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.papertrading.trading_server.dto.request.CreateInstrumentRequest;
import com.papertrading.trading_server.dto.response.InstrumentResponse;
import com.papertrading.trading_server.service.InstrumentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/v1/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentService instrumentService;

    @PostMapping()
    public ResponseEntity<InstrumentResponse> createInstrument(@Valid @RequestBody CreateInstrumentRequest request) {
        System.out.println("[DEBUG]");
        System.out.println(request);
        InstrumentResponse instrumentResponse = instrumentService.createInstrument(request);
        return new ResponseEntity<>(instrumentResponse, HttpStatus.CREATED);
    }
    
    
    @GetMapping()
    public ResponseEntity<InstrumentResponse> getInstrumentBySymbol(@RequestParam String symbol) {
        InstrumentResponse instrumentResponse = instrumentService.getInstrumentBySymbol(symbol);
        return new ResponseEntity<>(instrumentResponse, HttpStatus.OK);
    }
    
}
