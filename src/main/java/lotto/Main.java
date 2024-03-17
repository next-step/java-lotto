package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import lotto.domain.ExpressionElement;
import lotto.domain.ExpressionElementBuilder;
import lotto.util.ExpressionSplitter;
import lotto.ui.InputView;
import lotto.ui.ResultView;

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
