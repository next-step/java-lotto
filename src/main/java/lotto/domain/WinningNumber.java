package lotto.domain;

import lotto.domain.LottoGame;

import java.util.List;

public class WinningNumber {
    private static final int NUMBER_OF_WINNING_NUMBER = 6;
    List<Integer> numbers;

    public WinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException();
        }
        numbers = winningNumber;
    }

    public int matchCount(LottoGame lottoGame) {
        return (int) numbers.stream()
                .filter(number -> lottoGame.contains(number))
                .count();
    }
}
