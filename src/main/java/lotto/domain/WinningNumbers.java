package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    private WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = Lotto.of(numbers);
        this.bonusNumber = LottoNumber.getInstance(bonusNumber);
    }

    public static WinningNumbers getInstance(List<Integer> numbers, int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    public Rank getMatchResult(Lotto lotto) {
        return Rank.getWinningType(winningNumbers.countMatches(lotto), isBonusMatched(lotto));
    }

    private boolean isBonusMatched(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
