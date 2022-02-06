package stringcalculator;

import java.util.List;
import stringcalculator.domain.Accumulator;
import stringcalculator.domain.Delimiters;
import stringcalculator.domain.ExpressionParser;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String delimiter = InputView.inputDelimiter();
        String expression = InputView.inputExpression();

        ExpressionParser expressionParser = new ExpressionParser(new Delimiters(delimiter));
        List<Integer> numbers = expressionParser.parse(expression);

        int result = Accumulator.calculate(numbers);
        ResultView.print(result);
    }
}
