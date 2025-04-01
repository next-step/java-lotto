package lotto.domain;

import java.util.List;

public class FakeStrategy implements GeneratorStrategy {
    private final List<Integer> numbers;

    public FakeStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
