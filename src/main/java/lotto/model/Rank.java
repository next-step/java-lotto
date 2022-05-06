package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
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

    public static Rank of(int matchCount, boolean matchBonusNumber) {
        if (SECOND.isSameMatchCount(matchCount) && matchBonusNumber) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .filter(rank -> rank != SECOND)
                .findFirst()
                .orElse(OTHER);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
