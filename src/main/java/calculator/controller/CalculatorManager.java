package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorManager {
    public void start() {
        // 입력
        String inputExpression = Calculator.splitString(InputView.inputMathExprssion());

        int calculationResult = new Calculator().calculateExpression(inputExpression);

        // 결과
        ResultView.printExpressionResult(calculationResult);

    }
}
