package com.lotto.model;

import java.util.Set;

public class WinningNumbers {
    private static final int NUMBER_OF_WINNING_NUMBERS = 6;

    private final Set<Integer> numbers;

    public WinningNumbers(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException("잘못된 갯수의 숫자가 입력되었습니다. " + numbers);
        }

        this.numbers = numbers;
    }

    public int checkCorrectCount(Lotto lotto) {
        return (int) lotto.stream()
                .filter((number) -> numbers.contains(number))
                .count();
    }
}
