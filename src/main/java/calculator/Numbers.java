package calculator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Numbers(String input) {
        this(singletonList(new Number(input)));
    }

    public Numbers(String input, String delimiter) {
        this(stream(input.split(delimiter))
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
