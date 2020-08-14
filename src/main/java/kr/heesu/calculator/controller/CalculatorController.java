package kr.heesu.calculator.controller;

import kr.heesu.calculator.domain.Calculator;
import kr.heesu.calculator.domain.Expression;
import kr.heesu.calculator.utils.ExpressionFactory;
import kr.heesu.calculator.domain.Result;
import kr.heesu.calculator.view.InputView;
import kr.heesu.calculator.view.ResultView;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;

    private CalculatorController() {
        this.inputView = InputView.of();
        this.resultView = ResultView.of();
    }

    public void main() {
        String userInput = inputView.getUserInput();
        Expression expression = ExpressionFactory.getExpressionFromInput(userInput);

        Calculator calculator = Calculator.of(expression);

        while(calculator.hasNext()) {
            calculator.calculate();
        }

        Result result = calculator.getResult();

        resultView.printResult(result);
    }

    public static CalculatorController of() {
        return new CalculatorController();
    }
}
