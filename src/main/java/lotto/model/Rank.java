package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(1_500_000)),
    THIRD(4, new Money(50_000)),
    FOURTH(3, new Money(5_000)),
    OTHER(0, new Money(0));

    private final int matchCount;
    private final Money winnings;

    Rank(int matchCount, Money winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int matchCount() {
        return matchCount;
    }

    public Money winnings() {
        return winnings;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(OTHER);
    }
}
