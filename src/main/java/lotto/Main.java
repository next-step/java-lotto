package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import lotto.domain.ExpressionSplitter;
import lotto.exception.IllegalExpressionElementSizeException;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        try {
            String stringExpression = InputView.readExpression();
            Expression expression = ExpressionSplitter.split(stringExpression);

            Calculator calculator = new Calculator(expression);

        } catch (IllegalExpressionElementSizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            ResultView.printExit();
        }

    }

}
