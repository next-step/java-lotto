package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningNumber {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
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
