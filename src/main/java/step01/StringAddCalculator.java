package step01;

import java.util.Arrays;

public class StringAddCalculator {
    private static String PATTERN = "//(.)\n(.*)";

    public static int calculate(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> {
                    Int.validateNotNegative(a);
                    return a + b;
                });
    }

    public static int splitAndSum(String text) {
        if (Blank.validate(text))
            return 0;

        if (Int.isParsed(text))
            return Integer.parseInt(text);

        String[] numbers = Tokenizer.executeByPattern(text, PATTERN);

        return calculate(numbers);
    }
}
