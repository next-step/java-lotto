package stringAddCalculate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExpression {
    private final List<Number> numbers;

    public NumberExpression(final String expression) {
        this.numbers = convertToNumber(expression);
    }

    private List<Number> convertToNumber(final String expression) {
        String[] stringNumbers = StringSpliter.split(expression);
        return Arrays.stream(stringNumbers)
                .map(value -> new Number(Integer.parseInt(value)))
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
