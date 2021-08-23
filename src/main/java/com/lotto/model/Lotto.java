package com.lotto.model;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 갯수가 일치하지 않습니다.");
        }

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
