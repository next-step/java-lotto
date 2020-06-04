package com.cheolhyeonpark.lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean anyMatch(int number) {
        return numbers.stream().anyMatch(Predicate.isEqual(number));
    }
}
