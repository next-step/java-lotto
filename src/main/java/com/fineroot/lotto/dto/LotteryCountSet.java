package com.fineroot.lotto.dto;

import com.fineroot.lotto.util.ExceptionMessage;

public class LotteryCountSet {

    private final LotteryCount autoCount;
    private final LotteryCount manualCount;

    private LotteryCountSet(final LotteryCount totalCount, final LotteryCount manualCount) {
        if (totalCount.isLessThan(manualCount)) {
            throw new IllegalArgumentException(ExceptionMessage.MANUAL_LOTTERY_COUNT_OUT_OF_BOUND.getMessage());
        }
        this.manualCount = manualCount;
        this.autoCount = totalCount.subtract(manualCount);
    }

    public static LotteryCountSet of(int totalCount, int manualCount) {
        return new LotteryCountSet(LotteryCount.from(totalCount), LotteryCount.from(manualCount));
    }

    public static LotteryCountSet of(LotteryCount totalCount, LotteryCount manualCount) {
        return new LotteryCountSet(totalCount, manualCount);
    }

    public LotteryCount getAutoLotteryCount() {
        return autoCount;
    }

    public LotteryCount getManualLotteryCount() {
        return manualCount;
    }
}
