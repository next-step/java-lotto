package calculator;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class Validator {
    private static final Pattern PATTERN_FOR_NUMBER = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    public static boolean isNonBlank(String input) {
        return nonNull(input) && !input.isBlank();
    }

    public static boolean isNumber(String input) {
        return isNonBlank(input) && PATTERN_FOR_NUMBER.matcher(input).find();
    }

    public static boolean isGreaterThanOrEqualToLength(String[] stringArray, int length) {
        return stringArray.length >= length;
    }

    public static boolean isOddNumberLength(String[] stringArray) {
        return stringArray.length % 2 != 0;
    }
}
