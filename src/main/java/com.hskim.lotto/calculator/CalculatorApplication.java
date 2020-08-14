package com.hskim.lotto.calculator;

import com.hskim.lotto.model.CalculateResult;
import com.hskim.lotto.model.CalculatorNumberTokens;
import com.hskim.lotto.model.UserInput;
import com.hskim.lotto.ui.CalculatorInputView;
import com.hskim.lotto.ui.CalculatorResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.getInstance();
        CalculatorInputView calculatorInputView = new CalculatorInputView();
        CalculatorResultView calculatorResultView = new CalculatorResultView();
        CalculatorNumberTokens calculatorNumberTokens;
        CalculateResult calculateResult;

        calculatorInputView.printInputMessage();
        UserInput userInput = calculatorInputView.getUserInput();

        calculatorNumberTokens = CalculatorNumberTokens.of(userInput);
        calculateResult = stringAddCalculator.calculate(calculatorNumberTokens);

        calculatorResultView.printResult(calculateResult);
    }
}
