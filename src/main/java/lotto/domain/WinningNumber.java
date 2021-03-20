package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final int NUMBER_OF_WINNING_NUMBER = 6;
    private static final int DEFAULT_MIN_NUMBER = 1;
    private static final int DEFAULT_MAX_NUMBER = 45;

    List<Integer> numbers;

    public WinningNumber(List<Integer> winningNumber) {
        this(winningNumber, DEFAULT_MIN_NUMBER, DEFAULT_MAX_NUMBER);
    }

    public WinningNumber(List<Integer> winningNumber, int min, int max) {
        if (winningNumber.size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException("당첨 숫자는 개수는 불일치");
        }

        for (Integer number : winningNumber) {
            if (number < min || number > max)
                throw new IllegalArgumentException("당첨 숫자는 " + min + "이상, " + max + "이하값만 가능합니다.");
        }
        numbers = winningNumber;
    }

    public int matchCount(LottoGame lottoGame) {
        return (int) numbers.stream()
                .filter(number -> lottoGame.contains(number))
                .count();
    }

}
