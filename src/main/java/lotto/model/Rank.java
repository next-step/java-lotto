package lotto.model;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Rank {
    DEFAULT(0, 0, false),
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private final int match;
    private final int reward;
    private final boolean isBonus;

    Rank(final int match, final int reward, final boolean isBonus) {
        this.match = match;
        this.reward = reward;
        this.isBonus = isBonus;
    }

    static Rank match(final int count, final boolean isBonus) {
        return Arrays.stream(values())
                .filter(matchCount(count))
                .filter(matchBonus(count, isBonus))
                .findAny()
                .orElse(DEFAULT);
    }

    private static Predicate<Rank> matchCount(final int count) {
        return rank -> rank.match == count;
    }

    private static Predicate<Rank> matchBonus(final int count, final boolean isBonus) {
        if (count == Rank.FIVE_WITH_BONUS.match) {
            return rank -> rank.isBonus == isBonus;
        }
        return rank -> true;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return this.reward;
    }
}
