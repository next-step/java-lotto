package lotto.step1.domain;

import java.util.List;

public class Numbers {

    private List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }
}
