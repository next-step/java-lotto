package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import lotto.util.ExpressionSplitter;
import lotto.util.InputValidator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        try {
            String expressionString = InputView.readExpression();
            InputValidator.validateEmptyExpression(expressionString);

            String[] expressionStrings = ExpressionSplitter.split(expressionString);
            InputValidator.validateElementSize(expressionStrings.length);

            Calculator calculator = new Calculator(new Expression(expressionStrings));
            int result = calculator.calculate();

            ResultView.printExpressionResult(result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            ResultView.printExit();
        }

    }

}
