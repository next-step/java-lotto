package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(Collections.unmodifiableList(numbers));
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
}
