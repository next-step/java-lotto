package lotto.domain;

import java.util.Arrays;

public enum Reward {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    public static final int SECOND_SAME_NUMBER_COUNT = 5;
    private final int sameNumberCount;
    private final int money;

    Reward(int sameNumberCount, int money) {
        this.sameNumberCount = sameNumberCount;
        this.money = money;
    }

    public static Reward valueOf(int sameNumberCount, boolean containBonusBall) {
        if (isSecondReward(sameNumberCount, containBonusBall)) {
            return SECOND;
        }
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.sameNumberCount == sameNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecondReward(int sameNumberCount, boolean containBonusBall) {
        return containBonusBall && sameNumberCount == SECOND_SAME_NUMBER_COUNT;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getMoney() {
        return money;
    }
}
