package stringcalculator;

import stringcalculator.util.Delimiter;
import stringcalculator.domain.StringCalculator;
import stringcalculator.util.Converter;
import stringcalculator.view.InputView;
import java.util.List;
import stringcalculator.view.ResultView;

public class StringCalculatorMain {

    public static void main(String[] args) {
        String input = InputView.getExpression();
        int result = StringCalculator.add(input);
        ResultView.printResult(result);
    }
}
