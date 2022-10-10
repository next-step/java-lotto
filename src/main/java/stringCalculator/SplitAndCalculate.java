package stringCalculator;

import java.util.Arrays;
import java.util.List;

public class SplitAndCalculate {

    public int splitAndCalculate(String input) {
        Values values = new Values();
        Calculator calculator = new Calculator();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백과 null은 허용하지 않습니다.");
        }

        List<String> strings = splitString(input);
        for (String string : strings) {
            values.addValues(string);
        }

        return calculator.calculate(values.pollOperand(), values.pollOperand(), values);
    }


    public List<String> splitString(String s) {
        return Arrays.asList(s.split(" "));
    }
}
