package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String  defaultDelimiter = ",:";
    private static final Pattern customDelimiterPattern = Pattern.compile("//(?<delimiter>.)\n(?<expression>.*)");

    public static int splitAndSum(String expression) {
        if (Objects.isNull(expression)) {
            return 0;
        }
        return sum(split(expression));
    }

    private static List<String> split(String expression) {
        Matcher matcher = customDelimiterPattern.matcher(expression);
        if (matcher.find()) {
            return split(matcher.group("expression"), matcher.group("delimiter"));
        }
        return split(expression, defaultDelimiter);
    }

    private static List<String> split(String expression, String delimiter) {
        if (expression.isEmpty()) return Collections.emptyList();
        return Arrays.asList(expression.split("[" + delimiter + "]"));
    }

    private static int sum(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseUnsignedInt)  // throws NumberFormatException(is a RuntimeException) when negative integer
                .reduce(Integer::sum)
                .orElse(0);
    }
}
