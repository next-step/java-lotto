package stringaddcalculator.domain;

import stringaddcalculator.util.CustomSeparator;
import stringaddcalculator.util.DefaultSeparator;
import stringaddcalculator.util.Separator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    private final List<Number> numbers;

    private Numbers(String expression) {
        this(expression, new DefaultSeparator());
    }

    private Numbers(String expression, Separator separator) {
        this.numbers = convertToNumbers(expression, separator);
    }

    public static Numbers of(String expression) {
        if (isContainsCustomDelimiter(expression)) {
            return new Numbers(expression, new CustomSeparator());
        }
        return new Numbers(expression);
    }

    private static boolean isContainsCustomDelimiter(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private List<Number> convertToNumbers(String expression, Separator separator) {
        String[] splitExpression = separator.splitExpression(expression);
        return Arrays.stream(splitExpression)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::value)
                .sum();
    }
}
