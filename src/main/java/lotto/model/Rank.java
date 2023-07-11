package lotto.model;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_WITH_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);

    private final int match;
    private final int reward;
    private final boolean needBonus;

    Rank(final int match, final int reward, final boolean needBonus) {
        this.match = match;
        this.reward = reward;
        this.needBonus = needBonus;
    }

    static Rank match(final int count, final boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match == count)
                .filter(rank -> rank.needBonus == isBonus)
                .findAny()
                .orElseThrow();
    }

    public int getReward() {
        return this.reward;
    }
}
