package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.ExpressionElement;
import calculator.domain.ExpressionElementBuilder;
import calculator.util.ExpressionSplitter;
import calculator.ui.InputView;
import calculator.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            String expressionString = InputView.readExpression();
            List<String> expressionStrings = ExpressionSplitter.split(expressionString);

            List<ExpressionElement> elements = ExpressionElementBuilder.build(expressionStrings);
            int result = Calculator.calculate(new Expression(elements));

            ResultView.printExpressionResult(result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            e.printStackTrace();
        } finally {
            ResultView.printExit();
        }

    }

}
