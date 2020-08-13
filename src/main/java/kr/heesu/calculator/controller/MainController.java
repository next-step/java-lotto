package kr.heesu.calculator.controller;

import kr.heesu.calculator.domain.Calculator;
import kr.heesu.calculator.domain.Expression;
import kr.heesu.calculator.domain.InputParser;
import kr.heesu.calculator.domain.Result;
import kr.heesu.calculator.view.InputView;
import kr.heesu.calculator.view.ResultView;

public class MainController {

    private final InputView inputView;
    private final ResultView resultView;

    private MainController() {
        this.inputView = InputView.of();
        this.resultView = ResultView.of();
    }

    public void main() {
        String userInput = inputView.getUserInput();
        InputParser inputParser = InputParser.of(userInput);
        Expression expression = inputParser.getExpression();

        Calculator calculator = Calculator.of(expression);

        while(calculator.hasNext()) {
            calculator.calculate();
        }

        Result result = calculator.getResult();

        resultView.printResult(result);
    }
}
