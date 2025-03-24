import view.InputView;

import java.util.Arrays;

public class CalculatorApplication {

    public static void main(String[] args) {

        String expression = InputView.showExpressionInput();
        String[] parsedExpression = ExpressionParser.parse(expression);
        System.out.println(Arrays.toString(parsedExpression));
    }
}
