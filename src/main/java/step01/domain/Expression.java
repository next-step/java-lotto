package step01.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expression {

    private static final String DEFAULT_DELIMITER = " ";

    private final String value;

    public Expression(String value) {
        validateIsEmpty(value);
        this.value = value;
    }

    public CalculationPreset createCalculationPreset() {
        String[] split = value.split(DEFAULT_DELIMITER);

        List<Integer> numbers = new ArrayList<>();
        List<Operator> operations = new ArrayList<>();

        for (int i = 0; i < split.length; i += 2) {
            numbers.add(Integer.valueOf(split[i]));
        }

        for (int i = 1; i < split.length; i += 2) {
            operations.add(Operation.from(split[i]));
        }

        return new CalculationPreset(numbers, operations);
    }

    private void validateIsEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 문자는 비어있을 수 없습니다. | input: " + input);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Expression)) {
            return false;
        }

        Expression that = (Expression) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
