package lotto.model.generator;

import java.util.List;

public final class FixedNumbersGenerator implements NumbersGenerator {

    private final List<Integer> numbers;

    public FixedNumbersGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
