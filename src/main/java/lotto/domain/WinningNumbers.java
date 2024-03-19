package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final static String SPLIT_DELIMITER = ", ";
    private final static int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        if (hasNoInput(input)) {
            throw new IllegalArgumentException("당첨번호를 입력하지 않았습니다.");
        }

        this.numbers = toWinningNumbers(input);
    }

    private boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private List<Integer> toWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(toStringArray(input))
                .map(this::toLottoNumber)
                .collect(Collectors.toList());

        checkWinningNumberSize(winningNumbers);

        return winningNumbers;
    }

    private void checkWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨숫자 6개를 입력하세요.");
        }
    }

    private String[] toStringArray(String input) {
        return input.split(SPLIT_DELIMITER);
    }

    private Integer toLottoNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }

        if (!isLottoNumber(number)) {
            throw new IllegalArgumentException("로또숫자는 1-45 사이의 수를 입력하세요.");
        }

        return number;
    }

    private boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
