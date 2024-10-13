package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculate() {
        String input = inputView.askExpression();

        Expression expression = new Expression(input);
        Integer result = Calculator.calculate(expression);

        outputView.printCalculationResult(result);
    }
}
