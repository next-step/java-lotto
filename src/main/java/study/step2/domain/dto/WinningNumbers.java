package study.step2.domain.dto;

import java.util.List;

import study.step2.domain.exception.LottoException;

public class WinningNumbers {

    public static final int WINNING_NUMBERS_SIZE = 6;
    public static final int WINNING_START_NUMBER = 1;
    public static final int WINNING_END_NUMBER = 45;
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.winningNumbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new LottoException("당첨 번호 개수는 6개여야 합니다.");
        }

        if (!isValidNumbers(numbers)) {
            throw new LottoException("당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == WINNING_NUMBERS_SIZE;
    }

    private boolean isValidNumbers(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(n -> n >= WINNING_START_NUMBER && n <= WINNING_END_NUMBER);
    }

    public List<Integer> winningNumbers() {
        return winningNumbers;
    }
}
