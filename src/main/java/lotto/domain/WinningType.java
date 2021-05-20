package lotto.domain;

import java.util.stream.Stream;

public enum WinningType {
    FIRST(Money.from(2_000_000_000L), 6, false),
    SECOND(Money.from(30_000_000L), 5, true),
    THIRD(Money.from(1_500_000L), 5, false),
    FOURTH(Money.from(50_000L), 4, false),
    FIFTH(Money.from(5_000L), 3, false),
    NOTHING(Money.from(0L), 0, false);

    private final Money prize;
    private final int matchCount;
    private final boolean isBonusMatch;

    WinningType(Money prize, int matchCount, boolean isBonusMatch) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    private boolean isMatched(int countOfMatch, boolean isBonusMatch) {
        return this.matchCount == countOfMatch && this.isBonusMatch == isBonusMatch;
    }

    public static WinningType findType(int countOfMatch, boolean isBonusMatch) {
        return Stream.of(values())
                .filter(winningType -> winningType.isMatched(countOfMatch, isBonusMatch))
                .findFirst()
                .orElse(NOTHING);
    }

    public Money getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
