package calculator;

import calculator.domain.Expression;
import calculator.view.InputView;

public class Main {
    public static void main(String[] args) {
        Expression.createExpression(InputView.inputExpression());

    }
}
