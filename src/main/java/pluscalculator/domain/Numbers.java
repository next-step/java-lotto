package pluscalculator.domain;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int plusAll() {
        return numbers.stream().reduce(0, Integer::sum);
    }
}