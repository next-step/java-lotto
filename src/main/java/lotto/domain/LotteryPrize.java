package lotto.domain;

import java.util.Arrays;

public enum LotteryPrize {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0),
    UNDEFINED(0, 0);

    private int reward;

    private int matchingCount;

    LotteryPrize(int reward, int matchingCount) {
        this.reward = reward;
        this.matchingCount = matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public static LotteryPrize valueOf(int matchingCount, boolean isMatchingBonus) {
        return Arrays.stream(values())
                .filter(lotteryPrize -> isMatching(lotteryPrize, matchingCount, isMatchingBonus))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatching(LotteryPrize lotteryPrize, int matchingCount, boolean isMatchingBonus) {
        if (lotteryPrize == LotteryPrize.SECOND) {
            return lotteryPrize.matchingCount == matchingCount && isMatchingBonus;
        }
        return lotteryPrize.matchingCount == matchingCount;
    }

}
