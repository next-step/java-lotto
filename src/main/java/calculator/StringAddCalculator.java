package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int EMPTY_NUMBER = 0;
    private static final String DEFAULT_SEPARATOR_DELIMITER_REGEX = ",|:";

    private StringAddCalculator() {
    }

    public static int exec(String input) {

        if (isEmptyOrNull(input)) {
            return EMPTY_NUMBER;
        }

        if (isStringSingle(input)) {
            return Integer.parseInt(input);
        }

        String[] strings = collectStringNumbers(input);

        return sumResult(strings);
    }

    private static boolean isEmptyOrNull(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isStringSingle(String s) {
        return s.length() == 1;
    }

    private static String[] collectStringNumbers(String s) {
        Matcher match = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (match.find()) {
            String separator = match.group(1);
            String input = match.group(2);
            return splitStringByDelimiter(input, separator);
        }
        return splitStringByDelimiter(s, DEFAULT_SEPARATOR_DELIMITER_REGEX);
    }

    private static String[] splitStringByDelimiter(String s, String delimiter) {
        return s.split(delimiter);
    }

    private static int sumResult(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new RuntimeException("input negative numbers");
        }
        return number;
    }
}
