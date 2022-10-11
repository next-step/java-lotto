package stringCalculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SplitAndCalculate {

    public int splitAndCalculate(String input) {
        Values values = new Values();
        Calculator calculator = new Calculator();

        checkInputValue(input);

        splitString(input).forEach(s -> values.addValues(s));

        return calculator.calculate(values.pollOperand(), values.pollOperand(), values);
    }

    private void checkInputValue(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백과 null은 허용하지 않습니다.");
        }
    }

    public List<String> splitString(String s) {
        return Arrays.asList(s.split(" "));
    }
}
