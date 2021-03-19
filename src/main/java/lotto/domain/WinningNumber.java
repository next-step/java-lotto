package lotto.domain;

import lotto.domain.LottoGame;

import java.util.List;

public class WinningNumber {
    List<Integer> numbers;

    public  WinningNumber(List<Integer> winningNumber) {
        numbers = winningNumber;
    }

    public int matchCount(LottoGame lottoGame) {
        return (int)numbers.stream()
                .filter(number -> lottoGame.contains(number))
                .count();
    }
}
