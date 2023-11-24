package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.dto.WinningNumberSet;

public class LottoStore {
    private LottoBundle lottoBundle;

    public LottoStore() {
        lottoBundle = LottoBundle.from(0);
    }

    public void purchaseLottery(LottoPayment lottoPayment) {
        lottoBundle = LottoBundle.from(lottoPayment.toLotteryCount());
    }

    public void purchaseLottery(LotteryOrder lotteryOrder) {
        lottoBundle = lotteryOrder.lottoBundle();
    }

    public LottoBundleStatus lottoBundleStatus() {
        return lottoBundle.toLottoBundleStatus();
    }

    public WinnerStatus winnerStatus(WinningNumberSet winningNumberSet) {
        return lottoBundle.matchWinner(winningNumberSet);
    }
}
