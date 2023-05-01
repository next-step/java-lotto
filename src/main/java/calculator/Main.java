package calculator;

import calculator.domain.Expression;
import calculator.domain.Number;
import calculator.domain.StringExpressionParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String stringExpression = InputView.askExpression();
        Expression expression = StringExpressionParser.parse(stringExpression);
        Number result = expression.calculate();
        OutputView.printResult(result);
    }
}
