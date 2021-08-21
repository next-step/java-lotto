package com.lotto.model;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        String numberList = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        return "[" + numberList + "]";
    }

    public int countCorrectNumbers(Set<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter((number) -> numbers.contains(number))
                .count();
    }

    public boolean havingBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
