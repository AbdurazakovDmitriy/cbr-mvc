package com.currencyrate.mvc.service;

import com.currencyrate.mvc.api.CurrencyRatesService;
import com.currencyrate.mvc.exceptions.CurrencyRateNotFoundException;
import com.currencyrate.mvc.model.CurrencyRate;
import com.currencyrate.mvc.model.ValCurs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private final CbrService cbrService;

    @Override
    public CurrencyRate getCurrencyRate(String currency, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        ValCurs valCurs = cbrService.getRates(date.format(formatter));
        return valCurs.getValute().stream().filter(valute -> valute.getCharCode().equals(currency)).findAny()
                .orElseThrow(() -> new CurrencyRateNotFoundException(String.format("Currency %s with data %s not found", currency, date)));
    }

    @Override
    public List<CurrencyRate> getCurrencyRates(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        ValCurs valCurs = cbrService.getRates(date.format(formatter));
        return valCurs.getValute();
    }
}
