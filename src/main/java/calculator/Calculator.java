package calculator;

import java.util.Arrays;

public class Calculator {
    private static final String DELIMITERS = ",|:";

    static int[] extractNumbers(String input) {
        String[] numbers = input.split(DELIMITERS);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
