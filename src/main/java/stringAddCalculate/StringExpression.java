package stringAddCalculate;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringExpression {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final List<Number> numbers;

    public StringExpression(final String expression) {
        this.numbers = convertToNumber(expression);
    }

    public int sum() {
        return numbers.stream().map(Number::getNumber).reduce(0,Integer::sum);
    }

    private List<Number> convertToNumber(final String expression) {
        String[] stringNumbers = spliter(expression);
        return Arrays.stream(stringNumbers)
                .map(value -> new Number(Integer.parseInt(value)))
                .collect(Collectors.toList());
    }

    private String[] spliter(final String expression) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITER);
    }
}
