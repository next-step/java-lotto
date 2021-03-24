package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.StringAdditionExpression;
import calculator.view.InputView;
import calculator.view.PrintView;

public class CalculateController {
    public static void main(String[] args) {
        String input = new InputView().getInput();
        Expression expression = StringAdditionExpression.getExpression(input);
        int sum = Calculator.getInstance()
                .calculate(expression);

        new PrintView().print(sum);
    }
}
