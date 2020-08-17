package kr.heesu.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private boolean contain(int number) {
        return this.numbers.contains(number);
    }

    public Long match(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(this::contain)
                .count();
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return "[" + this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}

