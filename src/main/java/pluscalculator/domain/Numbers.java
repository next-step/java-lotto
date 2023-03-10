package pluscalculator.domain;

import java.util.List;

public class Numbers {
    private static Integer DEFAULT_VALUE = 0;

    private final List<Integer> numbers;

    public Numbers() {
        numbers = List.of(DEFAULT_VALUE);
    }

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int plusAll() {
        return numbers.stream().reduce(0, Integer::sum);
    }
}