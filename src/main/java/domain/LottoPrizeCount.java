package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoPrizeCount {
    private static final String FIRST_PRIZE_COUNT = "firstPrizeCount";
    private static final String SECOND_PRIZE_COUNT = "secondPrizeCount";
    private static final String THIRD_PRIZE_COUNT = "thirdPrizeCount";
    private static final String FOURTH_PRIZE_COUNT = "fourthPrizeCount";

    private Map<String, Long> lottoPrizeCount = new HashMap<>();

    public void incrementFirst() {
        lottoPrizeCount.put(FIRST_PRIZE_COUNT, lottoPrizeCount.getOrDefault(FIRST_PRIZE_COUNT, 0L) + 1);
    }

    public void incrementSecond() {
        lottoPrizeCount.put(SECOND_PRIZE_COUNT, lottoPrizeCount.getOrDefault(SECOND_PRIZE_COUNT, 0L) + 1);
    }

    public void incrementThird() {
        lottoPrizeCount.put(THIRD_PRIZE_COUNT, lottoPrizeCount.getOrDefault(THIRD_PRIZE_COUNT, 0L) + 1);
    }

    public void incrementFourth() {
        lottoPrizeCount.put(FOURTH_PRIZE_COUNT, lottoPrizeCount.getOrDefault(FOURTH_PRIZE_COUNT, 0L) + 1);
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
