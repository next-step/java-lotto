package stringaddcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String REGEX_FORMAT = "[%s]";
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_FORMAT = "//(.)\n(.*)";

    public static int splitAndSum(String input) {

        if (isEmptyString(input)) {
            return 0;
        }

        return operate(input);
    }

    private static int operate(String input) {
        int result = 0;

        String[] operands = splitInput(input);
        for (String operand : operands) {
            result += getValidValue(operand);
        }

        return result;
    }

    private static int getValidValue(String input) {
        int value = parseValidInt(input);

        if (value < 0) {
            throw new RuntimeException();
        }

        return value;
    }

    private static int parseValidInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_FORMAT).matcher(input);

        if (matcher.find()) {
            String delimiter = String.format(REGEX_FORMAT, matcher.group(1).concat(DEFAULT_DELIMITERS));
            return matcher.group(2).split(delimiter);
        }

        return input.split(String.format(REGEX_FORMAT, DEFAULT_DELIMITERS));
    }

    private static boolean isEmptyString(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }
}
