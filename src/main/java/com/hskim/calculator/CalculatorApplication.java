package com.hskim.calculator;

import com.hskim.calculator.model.CalculateResult;
import com.hskim.calculator.model.CalculatorNumberTokens;
import com.hskim.calculator.model.UserInput;
import com.hskim.calculator.ui.CalculatorInputView;
import com.hskim.calculator.ui.CalculatorResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.getInstance();
        CalculatorInputView calculatorInputView = new CalculatorInputView();
        CalculatorResultView calculatorResultView = new CalculatorResultView();
        CalculateResult calculateResult;

        calculatorInputView.printInputMessage();
        UserInput userInput = calculatorInputView.getUserInput();

        calculateResult = stringAddCalculator.calculate(CalculatorNumberTokens.of(userInput));

        calculatorResultView.printResult(calculateResult);
    }
}
