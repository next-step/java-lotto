package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;


public class WinningLotto {
    private final LottoNumbers winningNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoResult getResult(Lotto lotto) {
        return lotto.getMatchResult(winningNumbers);
    }
}
