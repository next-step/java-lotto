package stringcalculator;

import stringcalculator.domain.Delimiter;
import stringcalculator.domain.StringCalculator;
import stringcalculator.util.Converter;
import stringcalculator.view.InputView;
import java.util.List;
import stringcalculator.view.ResultView;

public class StringCalculatorMain {

    public static void main(String[] args) {
        String input = InputView.getExpression();
        Delimiter delimiter = new Delimiter(input);
        List<Integer> numbers = Converter.convertOperandType(delimiter.getNumbers());
        int result = StringCalculator.execute(numbers);
        ResultView.printResult(result);
    }
}
