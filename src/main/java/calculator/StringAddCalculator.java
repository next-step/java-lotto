package calculator;

import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return getSum(expression);
    }

    private static int getSum(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return getSum(tokens);
        }
        return getSum(expression.split("[,:]"));
    }

    private static int getSum(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .mapToInt(getNumberFromString())
                .sum();
    }

    private static ToIntFunction<String> getNumberFromString() {
        return string -> {
            int number = Integer.parseInt(string);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        };
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
