package com.calculator.converter;

import java.math.BigDecimal;
import java.math.MathContext;

public class UnitConverter {

    // Temperature Conversion (double is acceptable here)
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Currency Conversion (BigDecimal - precise money calculation)
    public BigDecimal usdToInr(BigDecimal usd) {
        BigDecimal rate = new BigDecimal("83.5");
        return usd.multiply(rate);
    }

    public BigDecimal inrToUsd(BigDecimal inr) {
        BigDecimal rate = new BigDecimal("83.5");
        return inr.divide(rate, MathContext.DECIMAL64);
    }

}