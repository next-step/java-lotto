package lotto.domain;

import java.util.Arrays;

public enum Reward {

    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int sameNumberCount;
    private final int money;

    Reward(int rightNumberCount, int money) {
        this.sameNumberCount = rightNumberCount;
        this.money = money;
    }

    public static Reward getRewardFromSameNumberCount(int sameNumberCount) {
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
