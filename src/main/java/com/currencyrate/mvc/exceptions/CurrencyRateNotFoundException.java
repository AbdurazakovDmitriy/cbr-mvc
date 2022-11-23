package com.currencyrate.mvc.exceptions;

public class CurrencyRateNotFoundException extends RuntimeException {

    public CurrencyRateNotFoundException(String message) {
        super(message);
    }
}
