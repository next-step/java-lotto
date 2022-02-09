package stringcalculator;

import java.util.List;
import stringcalculator.domain.Accumulator;
import stringcalculator.domain.Delimiters;
import stringcalculator.utils.ExpressionParser;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String delimiter = InputView.inputDelimiter();
        String expression = InputView.inputExpression();

        List<Integer> numbers = ExpressionParser.parse(expression, new Delimiters(delimiter).getValuesToString());

        int result = Accumulator.calculate(numbers);
        ResultView.print(result);
    }
}
