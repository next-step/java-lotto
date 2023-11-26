package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.LotteryOrderSet;

public class LotteryOrder {

    private final LotteryOrderSet lotteryOrderSet;
    private final LottoBundle lottoManualBundle;

    private LotteryOrder(final LotteryOrderSet lotteryOrderSet, final LottoBundle lottoManualBundle) {
        this.lotteryOrderSet = lotteryOrderSet;
        this.lottoManualBundle = lottoManualBundle;
    }

    public static LotteryOrder of(final LotteryOrderSet lotteryOrderSet, final LottoBundle lottoManualBundle) {
        return new LotteryOrder(lotteryOrderSet, lottoManualBundle);
    }

    public LottoBundle lottoBundle() {
        return lottoManualBundle.addBundle(LottoBundle.fromLotteryCount(lotteryOrderSet.getAutoLotteryCount()));
    }
}
