package lotto;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class Validator {
    private static final Pattern PATTERN_FOR_POSITIVE_INTEGER = Pattern.compile("^([1-9][0-9]*)$");
    private static final String ZERO_STRING = "0";

    private Validator() {
    }

    public static boolean isNonBlank(String string) {
        return nonNull(string) && !string.isBlank();
    }

    public static boolean isPositiveInteger(String numberString) {
        return isNonBlank(numberString) && PATTERN_FOR_POSITIVE_INTEGER.matcher(numberString).find();
    }

    public static boolean isIntegerGreaterThanOrEqualToZero(String numberString) {
        return isNonBlank(numberString) && (PATTERN_FOR_POSITIVE_INTEGER.matcher(numberString).find() || numberString.equals(ZERO_STRING));
    }

    public static boolean isEqualToLength(String[] stringArray, int length) {
        return stringArray.length == length;
    }

    public static boolean isInRange(int number, int minimum, int maximum) {
        return minimum <= number && number <= maximum;
    }
}
