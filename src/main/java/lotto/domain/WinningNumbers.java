package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public int numberOfSame(Lotto lotto) {
        return winningNumbers.numberOfSame(lotto);
    }

    public boolean isSameBonus(Lotto lotto) {
        return lotto.isBonusNumber(bonusNumber);
    }
}
