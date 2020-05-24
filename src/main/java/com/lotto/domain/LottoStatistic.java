package com.lotto.domain;

import java.util.List;

public class LottoStatistic {

    private LottoWinningNumbers lottoWinningNumbers;
    private List<Integer>

    public LottoStatistic() {
        this.lottoWinningNumbers = new LottoWinningNumbers();

    }

    public void calcualateLottoStatistic(String input) {
        this.lottoWinningNumbers.manipulateInputWinningLottoNumbers(input);

    }

}
