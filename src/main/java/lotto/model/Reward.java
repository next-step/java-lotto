package lotto.model;

import java.util.Arrays;

public enum Reward {
    SIXTH_PRIZE(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    Reward(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.prizeMoney = reward;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Reward makeReward(int matchCount, boolean isBonusBallMatched) {
        if (matchCount == SECOND_PRIZE.matchCount && isBonusBallMatched) {
            return SECOND_PRIZE;
        }

        return Arrays.stream(Reward.values())
                .filter(reward -> reward.matchCount == matchCount)
                .findAny()
                .orElse(SIXTH_PRIZE);
    }
}
