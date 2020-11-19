package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoPrizeCount {
    private Map<LottoPrize, Long> lottoPrizeCount = new HashMap<>();

    public LottoPrizeCount() {}

    public LottoPrizeCount(Map<LottoPrize, Long> lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public LottoPrizeCount incrementLottoPrize(LottoPrize lottoPrize) {
        lottoPrizeCount.put(lottoPrize, lottoPrizeCount.getOrDefault(lottoPrize, 0L) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public Long getFirstPrizeCount() {
        return lottoPrizeCount.getOrDefault(LottoPrize.FIRST_PRIZE, 0L);
    }

    public Long getSecondPrizeCount() {
        return lottoPrizeCount.getOrDefault(LottoPrize.SECOND_PRIZE, 0L);
    }

    public Long getThirdPrizeCount() {
        return lottoPrizeCount.getOrDefault(LottoPrize.THIRD_PRIZE, 0L);
    }

    public Long getFourthPrizeCount() {
        return lottoPrizeCount.getOrDefault(LottoPrize.FOURTH_PRIZE, 0L);
    }
}
