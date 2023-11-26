package com.fineroot.lotto.dto;

import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.util.ExceptionMessage;

public class LotteryOrderSet {

    private final LottoPayment lottoPayment;
    private final LotteryCount manualCount;

    private LotteryOrderSet(final LottoPayment lottoPayment, final LotteryCount manualCount) {
        if (lottoPayment.toLotteryCount().isLessThan(manualCount)) {
            throw new IllegalArgumentException(ExceptionMessage.MANUAL_LOTTERY_COUNT_OUT_OF_BOUND.getMessage());
        }
        this.manualCount = manualCount;
        this.lottoPayment = lottoPayment;
    }

    public static LotteryOrderSet of(int lottoPaymentValue, int manualCount) {
        return new LotteryOrderSet(LottoPayment.from(lottoPaymentValue), LotteryCount.from(manualCount));
    }

    public static LotteryOrderSet of(LottoPayment lottoPayment, LotteryCount manualCount) {
        return new LotteryOrderSet(lottoPayment, manualCount);
    }

    public LotteryCount getAutoLotteryCount() {
        return lottoPayment.toLotteryCount().subtract(manualCount);
    }

    public LotteryCount getManualLotteryCount() {
        return manualCount;
    }

    public LottoPayment getLottoPayment() {
        return lottoPayment;
    }
}
