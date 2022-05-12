package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = LottoNumberGenerator.createLottoNumber(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank findRank(Lotto lotto) {
        return Rank.of(lotto.matchCount(this.numbers), lotto.isMatchingBonus(this.bonusNumber));
    }
}
