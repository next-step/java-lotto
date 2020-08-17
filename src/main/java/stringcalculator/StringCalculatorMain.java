package stringcalculator;

import stringcalculator.expression.Expression;
import stringcalculator.expression.ExpressionNumber;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String values = InputView.expressionValue();

        Expression expression = Expression.newInstance(values);
        ExpressionNumber result = expression.sum();

        OutputView.printResult(result);
    }
}
