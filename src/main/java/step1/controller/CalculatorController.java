package step1.controller;

import step1.domain.Number;
import step1.domain.StringCalculator;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculatorController {
    private final InputView inputView;
    private final ResultView resultView;

    public CalculatorController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Number result = null;

        while (result == null) {
            result = getResult();
        }

        resultView.printResult(result);
    }

    private Number getResult() {
        String expression = inputView.getExpression();

        Number result = null;
        try {
            result = new StringCalculator(expression).calculate();
        } catch (Exception e) {
            resultView.printError();
        }

        return result;
    }
}
