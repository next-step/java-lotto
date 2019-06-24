package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.ConflictLottoNumberException;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    WinningLotto(final Lotto winningLotto,
                 final LottoNumber bonusLottoNumber) {
        if (winningLotto.contains(bonusLottoNumber)) {
            throw new ConflictLottoNumberException(bonusLottoNumber);
        }

        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }
}
