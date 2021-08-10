package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Reward {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int sameNumberCount;
    private final int money;

    Reward(int sameNumberCount, int money) {
        this.sameNumberCount = sameNumberCount;
        this.money = money;
    }

    public static Reward valueOf(int sameNumberCount, boolean containBonusBall) {
        if (containBonusBall && sameNumberCount == 5)
            return SECOND;
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.sameNumberCount == sameNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getMoney() {
        return money;
    }
}
