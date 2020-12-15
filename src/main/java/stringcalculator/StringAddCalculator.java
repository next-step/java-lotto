package stringcalculator;

import stringcalculator.domain.Calculator;
import stringcalculator.domain.Text;
import stringcalculator.utils.Splitter;

public class StringAddCalculator {
    private static final int END_NUMBER = 0;

    public static int splitAndSum(String input) {
        Text text = new Text(input);

        if(text.isBlank()) {
            return END_NUMBER;
        }

        Splitter splitter = new Splitter();
        String[] numbers = splitter.split(input);
        Calculator calculator = new Calculator(numbers);

        return calculator.add();
    }
}
