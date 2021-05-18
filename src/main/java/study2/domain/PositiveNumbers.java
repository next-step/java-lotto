package study2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    private PositiveNumbers(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public static PositiveNumbers of(String[] stringNumbers) {
        return of(Arrays.asList(stringNumbers));
    }

    public static PositiveNumbers of(List<String> stringNumbers) {
        List<PositiveNumber> numbers = stringNumbers.stream()
            .map(PositiveNumber::of)
            .collect(Collectors.toList());
        return new PositiveNumbers(numbers);
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(PositiveNumber::number)
            .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PositiveNumbers that = (PositiveNumbers)o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
