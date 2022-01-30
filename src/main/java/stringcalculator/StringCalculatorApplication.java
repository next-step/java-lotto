package stringcalculator;

import java.util.List;
import stringcalculator.domain.Accumulator;
import stringcalculator.domain.Delimiters;
import stringcalculator.domain.ExpressionParser;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        Delimiters delimiters = InputView.getDelimiters();
        List<Integer> numbers = null;

        try {
            String expression = InputView.getExpression();

            ExpressionParser expressionParser = new ExpressionParser(delimiters);
            numbers = expressionParser.parse(expression);
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
        }

        int result = Accumulator.calculate(numbers);
        ResultView.print(result);
    }
}
