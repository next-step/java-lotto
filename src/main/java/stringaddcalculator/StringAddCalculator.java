package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern COMPILE = Pattern.compile(",|:");

    public static Number splitAndSum(String expression) {
        if (expression == null) {
            return new Number(0);
        }

        if (expression.isEmpty()) {
            return new Number(0);
        }

        String[] numbers = COMPILE.split(expression);
        int result = Arrays.stream(numbers)
                           .map(Integer::parseInt)
                           .mapToInt(Integer::intValue)
                           .sum();

        return new Number(result);
    }
}
