package calculator;

import java.util.Arrays;

public class StringPlusCalculator {

    public int calculate(String input) {
        String[] result = StringSeparator.split(input);
        return Arrays.stream(result)
                .mapToInt(this::parseInt)
                .sum();
    }

    private int parseInt(String value) {
        int parse = Integer.parseInt(value);

        if (parse < 0) {
            throw new RuntimeException();
        }
        return parse;
    }
}
