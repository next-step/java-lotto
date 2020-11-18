package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoPrizeCount {
    private static final String FIRST_PRIZE_COUNT = "firstPrizeCount";
    private static final String SECOND_PRIZE_COUNT = "secondPrizeCount";
    private static final String THIRD_PRIZE_COUNT = "thirdPrizeCount";
    private static final String FOURTH_PRIZE_COUNT = "fourthPrizeCount";

    private Map<String, Long> lottoPrizeCount = new HashMap<>();

    public LottoPrizeCount() {}

    public LottoPrizeCount(Map<String, Long> lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public LottoPrizeCount incrementFirst() {
        lottoPrizeCount.put(FIRST_PRIZE_COUNT, lottoPrizeCount.getOrDefault(FIRST_PRIZE_COUNT, 0L) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public LottoPrizeCount incrementSecond() {
        lottoPrizeCount.put(SECOND_PRIZE_COUNT, lottoPrizeCount.getOrDefault(SECOND_PRIZE_COUNT, 0L) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public LottoPrizeCount incrementThird() {
        lottoPrizeCount.put(THIRD_PRIZE_COUNT, lottoPrizeCount.getOrDefault(THIRD_PRIZE_COUNT, 0L) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public LottoPrizeCount incrementFourth() {
        lottoPrizeCount.put(FOURTH_PRIZE_COUNT, lottoPrizeCount.getOrDefault(FOURTH_PRIZE_COUNT, 0L) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public Long getFirstPrizeCount() {
        return lottoPrizeCount.getOrDefault(FIRST_PRIZE_COUNT, 0L);
    }

    public Long getSecondPrizeCount() {
        return lottoPrizeCount.getOrDefault(SECOND_PRIZE_COUNT, 0L);
    }

    public Long getThirdPrizeCount() {
        return lottoPrizeCount.getOrDefault(THIRD_PRIZE_COUNT, 0L);
    }

    public Long getFourthPrizeCount() {
        return lottoPrizeCount.getOrDefault(FOURTH_PRIZE_COUNT, 0L);
    }
}
