package com.hskim.calculator;

import com.hskim.calculator.model.CalculateResult;
import com.hskim.calculator.model.CalculatorNumberTokens;

public class StringAddCalculator {

    private static StringAddCalculator stringAddCalculator = new StringAddCalculator();

    private StringAddCalculator() {

    }

    public static StringAddCalculator getInstance() {
        return stringAddCalculator;
    }

    public CalculateResult calculate(CalculatorNumberTokens calculatorNumberTokens) {
        return new CalculateResult(calculatorNumberTokens.getSum());
    }
}
