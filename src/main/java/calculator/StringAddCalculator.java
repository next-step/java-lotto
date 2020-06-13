package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR_REGEX = "[,:]";
    private static final String CUSTOM_SEPARATOR_WRAPPER_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_WRAPPER_POSTFIX = "\n";
    private static final String CUSTOM_SEPARATOR_INDICATOR = CUSTOM_SEPARATOR_WRAPPER_PREFIX + ".+" + CUSTOM_SEPARATOR_WRAPPER_POSTFIX;
    private static final Pattern CUSTOM_SEPARATOR_INDICATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_INDICATOR);
    private static final String BAD_EXPRESSION_NON_INTEGER = "The expression must consist only of integers separated by the specific separator.";
    private static final String BAD_EXPRESSION_NEGATIVE_INTEGER = "The negative integer cannot be passed.";

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        String[] intStrings = split(expression);
        return sum(intStrings);
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static String[] split(String expression) {
        Matcher matcher = CUSTOM_SEPARATOR_INDICATOR_PATTERN.matcher(expression);

        if (matcher.find()) {
            String expressionWithoutSeparator = expression.replaceAll(CUSTOM_SEPARATOR_INDICATOR, "");
            String customSeparator = substringCustomSeparator(matcher.group());

            return expressionWithoutSeparator.split(customSeparator);
        }

        return expression.split(DEFAULT_SEPARATOR_REGEX);
    }

    private static String substringCustomSeparator(String source) {
        int startIndex = source.indexOf(CUSTOM_SEPARATOR_WRAPPER_PREFIX) + CUSTOM_SEPARATOR_WRAPPER_PREFIX.length();
        int endIndex = source.indexOf(CUSTOM_SEPARATOR_WRAPPER_POSTFIX);
        return source.substring(startIndex, endIndex);
    }

    private static int sum(String[] strings) {
        try {
            return sumIntString(strings);
        } catch (NumberFormatException e) {
            throw new RuntimeException(BAD_EXPRESSION_NON_INTEGER);
        }
    }

    private static int sumIntString(String[] intStrings) {
        return Arrays.stream(intStrings)
                .mapToInt(StringAddCalculator::parseNonNegativeInt)
                .sum();
    }

    private static int parseNonNegativeInt(String s) {
        int value = Integer.parseInt(s);
        if (value < 0) {
            throw new RuntimeException(BAD_EXPRESSION_NEGATIVE_INTEGER);
        }
        return value;
    }
}
