package lotto.domain;

import java.util.stream.Stream;

public enum WinningType {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NOTHING(0, 0L);

    private final int matchCount;
    private final long prize;

    WinningType(int matchCount, long prize) {
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
}
