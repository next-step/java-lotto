package calculator.domain;

import calculator.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(final Values values) {
        List<Number> numbers = new ArrayList<>();
        for (String value : values.getValues()) {
            validateValue(value);
            numbers.add(Number.from(Integer.parseInt(value)));
        }
        return new Numbers(numbers);
    }

    private static void validateValue(final String value) {
        if (!StringUtils.isNumber(value)) {
            throw new RuntimeException("only number are available");
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
