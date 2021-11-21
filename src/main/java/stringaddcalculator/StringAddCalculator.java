package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final Pattern COMPILE = Pattern.compile(",|:");

    private StringAddCalculator() {
    }

    public static Number splitAndSum(String expression) {
        if (expression == null) {
            return new Number(0);
        }

        if (expression.isEmpty()) {
            return new Number(0);
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = m.group(2).split(customDelimiter);
            return new Number(sum(numbers));
        }

        String[] numbers = COMPILE.split(expression);
        return new Number(sum(numbers));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                     .map(Integer::parseInt)
                     .mapToInt(Integer::intValue)
                     .sum();
    }
}
