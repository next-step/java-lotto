package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class TestRandomNumbersGenerator implements RandomNumbersGenerator {

    private final List<Integer> numbers;

    public TestRandomNumbersGenerator(Integer[] numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    @Override
    public List<Integer> generateNumbers() {
        return this.numbers;
    }

}
