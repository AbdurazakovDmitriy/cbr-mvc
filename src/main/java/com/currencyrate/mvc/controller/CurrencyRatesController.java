package com.currencyrate.mvc.controller;

import com.currencyrate.mvc.api.CurrencyRatesService;
import com.currencyrate.mvc.model.CurrencyRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rates")
@RequiredArgsConstructor
@Slf4j
public class CurrencyRatesController {

    private final CurrencyRatesService ratesService;

    @GetMapping(value = "/currency/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyRate> getCurrencyRate(
            @PathVariable(value = "currency", required = false) String currency,
            @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date
    ) {
        log.info("Received request with currency: {} and date: {}", currency, date);
        return ResponseEntity.ok(ratesService.getCurrencyRate(currency, date));
    }

    @GetMapping(value = "/currencies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyRate>> getCurrencies(
            @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date
    ) {
        log.info("Received request with date: {}", date);
        return ResponseEntity.ok(ratesService.getCurrencyRates(date));
    }
}
