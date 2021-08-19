package lotto.domain;

import lotto.exception.BonusNumberException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new BonusNumberException();
        }
    }

    public Rank compareLotto(Lotto lotto) {
        int matchCount = winningLotto.compareLotto(lotto);
        boolean matchBonus = lotto.contains(bonusNumber);
        return Rank.rank(matchCount, matchBonus);
    }
}
