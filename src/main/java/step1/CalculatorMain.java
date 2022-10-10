package step1;

import step1.domain.Calculator;
import step1.domain.ExpressionParser;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ExpressionParser parsedExpression = new ExpressionParser(inputView.getInputLine());

        Calculator calculator = new Calculator();
        int result = calculator.calculateResult(parsedExpression.getParsed());

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}
