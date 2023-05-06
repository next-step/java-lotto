package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, null, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, null, 50_000),
    FIFTH(3, null, 5_000),
    MISS(0, null, 0);

    private int matchCount;
    private Boolean matchBonus;
    private int money;

    Rank(final int matchCount, final Boolean matchBonus, final int money) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.money = money;
    }

    public int matchCount() { return matchCount; }

    public int winnings() {
        return money;
    }

    private boolean isMatch(final int matchCount, final boolean matchBonus) {
        if (this.matchBonus != null) {
            return isMatchCountAndBonus(matchCount, matchBonus);
        }
        return isMatchCount(matchCount);
    }

    private boolean isMatchCount(final int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isMatchCountAndBonus(final int matchCount, final boolean matchBonus) {
        return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }

    public static Rank win(final int matchCount, final boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount, matchBonus))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
