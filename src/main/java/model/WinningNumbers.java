package model;

import java.util.List;

public class WinningNumbers {

    private static final int MAX_WINNING_NUMBERS = 6;

    private final List<Integer> numbers;

    public WinningNumbers(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() > MAX_WINNING_NUMBERS) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }
}
