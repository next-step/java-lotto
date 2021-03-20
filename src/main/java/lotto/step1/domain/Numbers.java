package lotto.step1.domain;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(final List<Number> numbers) {
        return new Numbers(numbers);
    }
}
