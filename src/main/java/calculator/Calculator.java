package calculator;

import java.util.Arrays;

public class Calculator {

    private static final String[] DELIMITERS = {",", ":"};
    private static final String DELIMITERS_REGEX = String.join("|", DELIMITERS);

    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(DELIMITERS_REGEX);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }


}
