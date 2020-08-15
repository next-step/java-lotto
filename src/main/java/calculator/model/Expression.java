package calculator.model;

import calculator.exception.CalculatorExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expression {

    private final List<Integer> numbers;

    public Expression(List<String> elements) {
        numbers = new ArrayList<>();
        for (String element : elements) {
            numbers.add(parseValidNumber(element));
        }
    }

    public int addNumbers() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Integer parseValidNumber(String input) {
        Integer number = parseInteger(input);
        if (number < 0) {
            throw new IllegalArgumentException(CalculatorExceptionMessage.INVALID_NUMBER);
        }

        return number;
    }

    private Integer parseInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(CalculatorExceptionMessage.INVALID_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
