package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {
    private final List<Number> numbers;

    public static Numbers from(String[] texts) {
        List<Number> numbers = Stream.of(texts)
                                    .map(Number::new)
                                    .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream()
                    .mapToInt(Number::getValue)
                    .sum();
    }
}
