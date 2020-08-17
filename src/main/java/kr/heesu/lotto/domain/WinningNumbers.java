package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Message;

import java.util.List;

public class WinningNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        if (isNotValid(numbers)) {
            throw new IllegalArgumentException(Message.EXCEPTION_FOR_WINNING_NUMBERS.of());
        }
        this.numbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return this.numbers;
    }

    private boolean isInRange(int number) {
        return number < MIN || number > MAX;
    }

    private boolean isNotValid(List<Integer> numbers) {
        if (numbers.size() < SIZE) {
            return true;
        }

        long count = numbers.stream()
                .filter(this::isInRange)
                .count();

        return count > 0;
    }

    public static WinningNumbers of(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }
}

