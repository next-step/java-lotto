package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.valueOf(2000000000)),
    SECOND(5, Money.valueOf(30000000)),
    THIRD(5, Money.valueOf(1500000)),
    FOURTH(4, Money.valueOf(50000)),
    FIFTH(3, Money.valueOf(5000)),
    UN_RANK(2, Money.zero());

    private final int match;
    private final Money reward;

    Rank(final int match, final Money reward) {
        this.match = match;
        this.reward = reward;
    }

    public static Rank countOf(final int count, final boolean matchBonus) {
        if (SECOND.match == count && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank != SECOND)
                .filter(rank -> rank.isMatch(count))
                .findFirst()
                .orElse(UN_RANK);
    }

    private boolean isMatch(final int count) {
        return match == count;
    }

    public int getMatch() {
        return match;
    }

    public Money getReward() {
        return reward;
    }

    public boolean isWinning() {
        return UN_RANK != this;
    }
}
