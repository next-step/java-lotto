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
    private final boolean bonusBall;
    private final int prizeMoney;

    Reward(int matchCount, boolean bonusBall, int reward) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.prizeMoney = reward;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private int getMatchCount() {
        return this.matchCount;
    }

    public static Reward getReward(int matchCount, boolean bonusBall) {
        if (matchCount == SECOND_PRIZE.matchCount && bonusBall == SECOND_PRIZE.bonusBall) {
            return SECOND_PRIZE;
        }

        return Arrays.stream(Reward.values())
                .filter(reward -> reward.getMatchCount() == matchCount)
                .findAny()
                .orElse(SIXTH_PRIZE);
    }
}
