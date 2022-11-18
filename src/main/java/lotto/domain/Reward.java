package lotto.domain;

import java.util.Arrays;

public enum Reward {
    FIRST(6, 2_000_000_000, BonusRequiredType.NO_MATTER),
    SECOND(5, 30_000_000, BonusRequiredType.REQUIRED),
    THIRD(5, 1_500_000, BonusRequiredType.NOT_REQUIRED),
    FOURTH(4, 50_000, BonusRequiredType.NO_MATTER),
    FIFTH(3, 5_000, BonusRequiredType.NO_MATTER),
    MISS(0, 0, BonusRequiredType.NO_MATTER);

    int matchCount;
    int money;
    BonusRequiredType bonusRequiredType;

    Reward(int matchCount, int money, BonusRequiredType bonusRequiredType) {
        this.matchCount = matchCount;
        this.money = money;
        this.bonusRequiredType = bonusRequiredType;
    }

    public static Reward getRewardByMatchCount(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
            .filter(reward -> reward.matchCount == (matchCount) && reward.bonusRequiredType.evaluate(hasBonusNumber))
            .findFirst()
            .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
