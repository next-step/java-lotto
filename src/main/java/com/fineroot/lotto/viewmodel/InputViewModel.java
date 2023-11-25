package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.domain.LotteryOrder;
import com.fineroot.lotto.domain.LottoBundle;
import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.dto.LotteryOrderSet;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.dto.WinningNumberSet;
import com.fineroot.lotto.util.LottoUtils;

public class InputViewModel {

    private LottoPayment lottoPayment;
    private WinningNumber winningNumber;
    private LottoNumber bonusNumber;
    private LotteryOrderSet lotteryOrderSet;
    private LottoBundle lottoBundle;

    public InputViewModel() {
        this.lottoPayment = LottoPayment.from(0);
        this.winningNumber = WinningNumber.defaultCreate();
        this.bonusNumber = LottoNumber.from(1);
        this.lotteryOrderSet = LotteryOrderSet.of(LottoUtils.LOTTO_EACH_PRICE, 0);
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

    public WinningNumberSet getWinningNumberSet() {
        return WinningNumberSet.of(winningNumber, bonusNumber);
    }

    public void saveManualPurchaseCount(LotteryCount count) {
        lotteryOrderSet = LotteryOrderSet.of(lottoPayment, count);
    }

    public void saveManualLottoBundle(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public LotteryOrder getLotteryOrder() {
        return LotteryOrder.of(lotteryOrderSet, lottoBundle);
    }

    public LotteryOrderSet getLotteryOrderSet(){
        return lotteryOrderSet;
    }

    public boolean manualLotteryIsGreaterThan(final int index) {
        return lotteryOrderSet.getManualLotteryCount().isGreaterThanFromInteger(index);
    }
}
