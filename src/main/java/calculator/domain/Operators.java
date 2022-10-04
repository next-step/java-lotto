package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Operators {

    private static final String MIN_SIZE_MESSAGE = "적어도 1개의 연산자가 입력되어야 합니다.";

    private final List<Operator> values;

    public Operators(final List<Operator> values) {
        validateMinSize(values.size());
        this.values = values;
    }

    public static Operators of(final List<String> values) {
        return new Operators(parseOperator(values));
    }

    private static void validateMinSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException(MIN_SIZE_MESSAGE);
        }
    }

    private static List<Operator> parseOperator(List<String> values) {
        return values.stream()
                .map(Operator::of)
                .collect(Collectors.toList());
    }

    public int size() {
        return values.size();
    }

    public int operate(int index, int firstNumber, int secondNumber) {
        return values
                .get(index)
                .operate(firstNumber, secondNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operators operators = (Operators) o;
        return Objects.equals(values, operators.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
