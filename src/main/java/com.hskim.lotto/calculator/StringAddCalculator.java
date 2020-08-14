package com.hskim.lotto.calculator;

import com.hskim.lotto.model.CalculateResult;
import com.hskim.lotto.model.CalculatorNumberTokens;

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
