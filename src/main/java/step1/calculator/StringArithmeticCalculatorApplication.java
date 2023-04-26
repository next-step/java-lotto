package step1.calculator;

import step1.calculator.domain.UserInput;
import step1.calculator.domain.Expression;
import step1.calculator.util.ExpressionParser;
import step1.calculator.view.InputView;
import step1.calculator.view.ResultView;

public class StringArithmeticCalculatorApplication {

    public static void main(String[] args) {
        UserInput userInput = InputView.getUserInput();
        Expression expression = ExpressionParser.parse(userInput);

        int calculatedResult = expression.getCalculateResult();
        ResultView.printResult(calculatedResult);
    }
}
