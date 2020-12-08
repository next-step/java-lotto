package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(Collections.unmodifiableList(numbers));
    }

    public static Numbers of(final String... values) {
        return of(Stream.of(values)
                .mapToInt(Integer::parseInt)
                .toArray());
    }

    public static Numbers of(final int... values) {
        return IntStream.of(values)
                .mapToObj(Number::valueOf)
                .collect(collectingAndThen(toList(), Numbers::new));
    }

    public Number sum() {
        return numbers.stream()
                .reduce(Number::sum)
                .orElse(Number.valueOf(0));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        final Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
