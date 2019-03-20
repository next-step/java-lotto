package calculator.view;

import calculator.Expression;
import calculator.StringAdditionCalculator;

public class MainView {
    public static void main(String[] args) {
        String expression = InputView.input();
        int result = 0;

        if (!Expression.isNullOrEmpty(expression)) {
            result = StringAdditionCalculator.add(Expression.extractOperands(expression));
        }

        OutputView.print(result);
    }
}
