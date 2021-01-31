package calculator.string.controller;

import calculator.string.domain.Calculator;
import calculator.string.domain.StringCalculator;
import calculator.string.view.Input;
import calculator.string.view.Output;

public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator){
        this.calculator = calculator;
    }

    public void prepareCalculator() {
        Output.printInputMessage();
        String expression = Input.expressionInput();
        calculator.inputExpression(expression);
    }

    public void executeCalculator() {
        Output.printResultMessage(calculator.calculation());
    }
}
