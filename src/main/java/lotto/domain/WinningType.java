package lotto.domain;

import java.util.stream.Stream;

public enum WinningType {
    FIRST(6, Money.from(2_000_000_000L)),
    SECOND(5, Money.from(1_500_000)),
    THIRD(4, Money.from(50_000L)),
    FOURTH(3, Money.from(5_000L)),
    NOTHING(0, Money.from(0L));

    private final int matchCount;
    private final Money prize;

    WinningType(int matchCount, Money prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private boolean isSameCount(int countOfMatch) {
        return this.matchCount == countOfMatch;
    }

    public static WinningType findType(int countOfMatch) {
        return Stream.of(values())
                .filter(winningType -> winningType.isSameCount(countOfMatch))
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
