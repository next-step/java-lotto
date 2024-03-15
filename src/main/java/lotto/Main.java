package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import lotto.domain.ExpressionSplitter;
import lotto.domain.ExpressionValidator;
import lotto.exception.IllegalExpressionElementSizeException;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        try {
            String stringExpression = InputView.readExpression();
            ExpressionValidator.validateEmptyExpression(stringExpression);

            Expression expression = ExpressionSplitter.split(stringExpression);

            Calculator calculator = new Calculator(expression);
            int result = calculator.calculate();

            ResultView.printExpressionResult(result);
        } catch (IllegalExpressionElementSizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            ResultView.printExit();
        }

    }

}
