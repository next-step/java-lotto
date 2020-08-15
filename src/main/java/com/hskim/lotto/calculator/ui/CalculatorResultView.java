package com.hskim.lotto.calculator.ui;

import com.hskim.lotto.calculator.model.CalculateResult;

public class CalculatorResultView {

    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(CalculateResult calculateResult) {
        System.out.println(RESULT_MESSAGE + calculateResult.createResultString());
    }
}
