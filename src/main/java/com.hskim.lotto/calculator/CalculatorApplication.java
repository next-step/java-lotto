package com.hskim.lotto.calculator;

import com.hskim.lotto.model.PositiveNumberTokens;
import com.hskim.lotto.ui.CalculatorInputView;
import com.hskim.lotto.ui.CalculatorResultView;

public class CalculatorApplication {

    public static void main(String[] args) {

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        CalculatorInputView calculatorInputView = new CalculatorInputView();
        CalculatorResultView calculatorResultView = new CalculatorResultView();
        PositiveNumberTokens positiveNumberTokens;

        calculatorInputView.printInputMessage();
        String userInput = calculatorInputView.getUserInput();

        positiveNumberTokens = new PositiveNumberTokens(calculatorInputView.makeTokenList(userInput));

        calculatorResultView.printResult(stringAddCalculator, positiveNumberTokens);
    }
}
