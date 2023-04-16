package calculator;

import calculator.domain.Expression;
import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class Main {
    public static void main(String[] args) {
        Expression expression = Expression.createExpression(InputView.inputExpression());
        StringCalculator calculator = new StringCalculator(expression);

        calculator.calculate();
    }
}
