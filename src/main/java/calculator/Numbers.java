package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Numbers(int input) {
        this(singletonList(new Number(input)));
    }

    public Numbers(String[] input) {
        this(stream(input)
                .map(Number::new)
                .collect(Collectors.toList())
        );
    }

    public int sum() {
        int sum = 0;

        for (Number number : numbers) {
            sum += number.getValue();
        }

        return sum;
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
