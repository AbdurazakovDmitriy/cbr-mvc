package com.currencyrate.mvc.api;

import com.currencyrate.mvc.model.CurrencyRate;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRatesService {

    CurrencyRate getCurrencyRate(String currency, LocalDate date);

    List<CurrencyRate> getCurrencyRates(LocalDate date);

}
