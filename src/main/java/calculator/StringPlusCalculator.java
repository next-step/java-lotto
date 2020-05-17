package calculator;

import java.util.Arrays;

public class StringPlusCalculator {

    public int calculate(String input) {
        String[] result = StringSeparator.split(input);
        return Arrays.stream(result)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
