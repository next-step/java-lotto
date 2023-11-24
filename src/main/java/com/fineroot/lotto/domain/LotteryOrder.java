package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.LotteryCount;

public class LotteryOrder {

    private final LottoBundle lottoBundle;

    private LotteryOrder(final LotteryCount autoLotteryCount, final LottoBundle manualLottoNumbers) {
        this.lottoBundle = manualLottoNumbers.addBundle(LottoBundle.fromLotteryCount(autoLotteryCount));
    }

    public static LotteryOrder of(final LotteryCount autoLotteryCount, final LottoBundle manualLottoNumbers) {
        return new LotteryOrder(autoLotteryCount, manualLottoNumbers);
    }

    public LottoBundle lottoBundle() {
        return lottoBundle;
    }
}
