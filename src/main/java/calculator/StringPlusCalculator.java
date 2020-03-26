package calculator;

import java.util.stream.Stream;

public class StringPlusCalculator {

    private static final String DEFAULT_REGEX = "[,:]";

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return Stream.of(input.split(DEFAULT_REGEX))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
