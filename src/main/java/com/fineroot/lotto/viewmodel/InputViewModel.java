package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.dto.LotteryCount;
import com.fineroot.lotto.dto.LotteryCountSet;
import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.dto.WinningNumberSet;

public class InputViewModel {

    private LottoPayment lottoPayment;
    private WinningNumber winningNumber;
    private LottoNumber bonusNumber;
    private LotteryCountSet lotteryCountSet;

    public InputViewModel() {
        this.lottoPayment = LottoPayment.from(0);
        this.winningNumber = WinningNumber.defaultCreate();
        this.bonusNumber = LottoNumber.from(1);
        this.lotteryCountSet = LotteryCountSet.of(1, 1);
    }

    public void saveLottoPayment(LottoPayment lottoPayment) {
        this.lottoPayment = lottoPayment;
    }

    public void saveWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void saveBonusNumber(LottoNumber number) {
        this.bonusNumber = number;
    }

    public LottoPayment getLottoPayment() {
        return lottoPayment;
    }

    public WinningNumberSet getWinningNumberSet() {
        return WinningNumberSet.of(winningNumber, bonusNumber);
    }

    public void saveManualPurchaseCount(LotteryCount count) {
        lotteryCountSet = LotteryCountSet.of(LotteryCount.from(lottoPayment.toLotteryCount()), count);
    }

    public LotteryCountSet getLotteryCountSet() {
        return lotteryCountSet;
    }
}
