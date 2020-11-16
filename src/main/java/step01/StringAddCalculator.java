package step01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String TOKENS = ",|:";
    private static String PATTERN = "//(.)\n(.*)";
    private static int DELIMITER = 1;
    private static int CONTENTS = 2;


    private static Matcher matchPattern(String input) {
        return Pattern.compile(PATTERN).matcher(input);
    }

    private static String[] tokenize(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static String[] tokenize(String input, Matcher matcher) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER);
            return tokenize(matcher.group(CONTENTS), customDelimiter);
        }
        return tokenize(input, TOKENS);
    }



    public static int calculate(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> {
                    Int.validateNotNegative(a);
                    return a + b;
                });
    }

    public static int splitAndSum(String input) {
        if (Blank.validate(input))
            return 0;

        if (Int.isParsed(input))
            return Integer.parseInt(input);

        String[] numbers = tokenize(input, matchPattern(input));

        return calculate(numbers);

    }
}
