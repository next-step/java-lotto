package stringcaculator.domain;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream()
            .map(Number::value)
            .mapToInt(i -> i)
            .sum();
    }
}
