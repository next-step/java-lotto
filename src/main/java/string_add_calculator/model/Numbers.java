package string_add_calculator.model;

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
                .map(Number::of)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public Number sum() {
        Number result = Number.of(0);

        for (Number number : numbers) {
            result = number.add(result);
        }

        return result;
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
