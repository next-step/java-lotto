package calculator;

import calculator.domain.Expression;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Expression expression = Expression.createExpression(InputView.inputExpression());

        StringCalculator calculator = new StringCalculator(expression);

        OutputView.printResult(calculator.calculate());
    }
}
