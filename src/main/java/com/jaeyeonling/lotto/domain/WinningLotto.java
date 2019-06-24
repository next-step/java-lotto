package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.ConflictLottoNumberException;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(final Lotto winningLotto,
                        final LottoNumber bonusLottoNumber) {
        if (winningLotto.contains(bonusLottoNumber)) {
            throw new ConflictLottoNumberException(bonusLottoNumber);
        }

        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    LottoPrize match(final Lotto comparisonTarget) {
        final int countOfMatch = winningLotto.countOfMatch(comparisonTarget);
        final boolean matchBonus = comparisonTarget.contains(bonusLottoNumber);

        return LottoPrize.valueOf(countOfMatch, matchBonus);
    }
}

