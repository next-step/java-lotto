package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.Number;
import calculator.domain.StringExpressionParser;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * @author : 0giri
 * @since : 2023/04/26
 */
public class Main {
    public static void main(String[] args) {
        String stringExpression = InputView.askExpression();
        Expression expression = StringExpressionParser.parse(stringExpression);
        Number result = Calculator.calculate(expression);
        OutputView.printResult(result);
    }
}
