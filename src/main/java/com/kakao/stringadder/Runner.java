package com.kakao.stringadder;

import com.kakao.stringadder.domain.calculator.StringAddCalculator;
import com.kakao.stringadder.ui.InputView;
import com.kakao.stringadder.ui.OutputView;

public class Runner {
    public static void main(String[] args) {
        String expression = InputView.expression(System.in);
        int result = StringAddCalculator.splitAndSum(expression);
        OutputView.printCalculationResult(result);
    }
}
