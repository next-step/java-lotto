package me.daeho.lotto.domain;

import java.util.*;

public class Lotto {
    private static final int NUMBER_COUNT = 6;

    private final Set<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = new HashSet<>(NUMBER_COUNT);
        this.numbers.addAll(numbers);
        validateNumberSize(this.numbers);
    }

    private void validateNumberSize(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT)
            throw new IllegalArgumentException();
    }

    public static Lotto issue(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public long containsCount(List<Integer> checkNumbers) {
        return checkNumbers.stream()
                .filter(numbers::contains)
                .count();
    }
}
