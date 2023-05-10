package calculator;

import calculator.domain.UserInput;
import calculator.domain.Expression;
import calculator.util.ExpressionParser;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringArithmeticCalculatorApplication {

    public static void main(String[] args) {
        UserInput userInput = InputView.getUserInput();
        Expression expression = ExpressionParser.parse(userInput);

        int calculatedResult = expression.getCalculateResult();
        ResultView.printResult(calculatedResult);
    }
}
