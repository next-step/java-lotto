package com.hskim.lotto.ui;

import com.hskim.lotto.calculator.StringAddCalculator;
import com.hskim.lotto.model.PositiveNumberTokens;

public class CalculatorResultView {

    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(StringAddCalculator stringAddCalculator, PositiveNumberTokens positiveNumberTokens) {

        System.out.print(RESULT_MESSAGE);
        System.out.println(stringAddCalculator.calculate(positiveNumberTokens));
    }
}
