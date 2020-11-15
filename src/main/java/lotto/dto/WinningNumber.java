package lotto.dto;

import lotto.domain.Lotto;

public class WinningNumber {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchedCountCompareTo(Lotto boughtLotto) {
        return winningLotto.getMatchedCountCompareTo(boughtLotto);
    }

    public boolean isBonusNumMatchedTo(Lotto boughtLotto) {
        return boughtLotto.contains(bonusNumber);
    }
}
