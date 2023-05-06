package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int money;

    Rank(final int matchCount, final int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int matchCount() { return matchCount; }

    public int winnings() {
        return money;
    }

    private boolean isMatch(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public static Rank win(final int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
