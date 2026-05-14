package com.calculator.scientific;

import com.calculator.basic.BasicCalculator;
import java.math.BigDecimal;
import java.math.MathContext;

public class ScientificCalculator extends BasicCalculator {

    public BigDecimal squareRoot(BigDecimal a) {
        if (a.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Cannot find square root of negative number");
        }
        return a.sqrt(MathContext.DECIMAL64);
    }

    public BigDecimal power(BigDecimal base, int exponent) {
        return base.pow(exponent);
    }

}