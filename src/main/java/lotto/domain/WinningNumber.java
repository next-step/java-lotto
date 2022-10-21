package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank calcLottoRankWithBonus(Lotto lotto) {
        return lotto.calculateRank(numbers, bonusNumber);
    }
}
