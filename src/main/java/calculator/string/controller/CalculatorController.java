package calculator.string.controller;

import calculator.string.domain.Calculator;
import calculator.string.domain.StringCalculator;
import calculator.string.view.Input;
import calculator.string.view.Output;

public class CalculatorController {

    public String prepareCalculator() {
        Output.printInputMessage();
        String expression = Input.expressionInput();
        return expression;
    }

    public int executeCalculator(String expression) {
        Calculator stringCalculator = new StringCalculator();
        stringCalculator.inputExpression(expression);
        return stringCalculator.calculation();
    }

    public void endCalculator(int result){
        Output.printResultMessage(result);
    }
}
