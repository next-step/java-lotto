package com.nextstep.camp.lotto.view.dto;

import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class LottoInputData {
    private final LottoAmount lottoAmount;
    private final WinningNumbers winningNumbers;

    private LottoInputData(LottoAmount lottoAmount, WinningNumbers winningNumbers) {
        this.lottoAmount = lottoAmount;
        this.winningNumbers = winningNumbers;
    }

    public static LottoInputData of(LottoAmount lottoAmount, WinningNumbers winningNumbers) {
        return new LottoInputData(lottoAmount, winningNumbers);
    }

    public LottoAmount getLottoAmount() {
        return lottoAmount;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
