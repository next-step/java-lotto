package step1.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    List<Number> numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(n -> Number.createFromString(n))
                .collect(Collectors.toList());
    }

    public List<Number> getList() {
        return Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        return Number.createFromInt(numbers.stream()
                .mapToInt(Number::getNumber)
                .sum()
        );
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
