package com.monds.nextstep.lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking matching(Lotto lotto) {
        return LottoRanking.valueOf(winningLotto.countOfMatch(lotto), lotto.contains(bonusNumber));
    }
}
