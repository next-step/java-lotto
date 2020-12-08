package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        if (expression.contains(":") || expression.contains(",")) {
            return Arrays.stream(expression.split(",|:"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.stream(m.group(2).split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Integer.parseInt(expression);
    }
}
