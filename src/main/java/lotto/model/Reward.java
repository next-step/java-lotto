package lotto.model;

import java.util.Arrays;

public enum Reward {
    SIXTH_PRIZE(0, false, 0),
    FIFTH_PRIZE(3, false, 5_000),
    FOURTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean isBonusBallMatched;
    private final int prizeMoney;

    Reward(int matchCount, boolean isBonusBallMatched, int reward) {
        this.matchCount = matchCount;
        this.isBonusBallMatched = isBonusBallMatched;
        this.prizeMoney = reward;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Reward getReward(int matchCount, boolean isBonusBallMatched) {
        if (matchCount == SECOND_PRIZE.matchCount && isBonusBallMatched == SECOND_PRIZE.isBonusBallMatched) {
            return SECOND_PRIZE;
        }

        return Arrays.stream(Reward.values())
                .filter(reward -> reward.matchCount == matchCount)
                .findAny()
                .orElse(SIXTH_PRIZE);
    }
}
