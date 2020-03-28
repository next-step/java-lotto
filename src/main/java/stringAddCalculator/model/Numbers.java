package stringAddCalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers create(final String[] numbersString) {
        List<Number> numbers = Arrays.stream(numbersString)
                .map(Number::newInstance)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::toInt)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
