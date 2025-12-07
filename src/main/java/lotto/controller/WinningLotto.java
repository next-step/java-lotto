package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;


public class WinningLotto {
    LottoNumbers winningNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public String getResult(Lotto lotto) {
        return lotto.getMatchResult(winningNumbers).toString();
    }

    public String getProfit(Lotto lotto) {
        LottoResult lottoResult = lotto.getMatchResult(winningNumbers);
        return String.valueOf(lotto.calculateProfit(lottoResult.prize()));
    }
}
