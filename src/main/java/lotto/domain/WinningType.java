package lotto.domain;

import java.util.Arrays;

public enum WinningType {
    NO_MATCH(0, 0, 0),
    FOURTH(5_000, 4, 3),
    THIRD(50_000, 3, 4),
    SECOND(1_500_000, 2, 5),
    FIRST(2_000_000_000, 1, 6);

    private int prize;
    private int rank;
    private int matchCount;

    public int getPrize() {
        return prize;
    }

    public static WinningType findByMatchCount(int matchCount) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchCount == matchCount)
                .findAny()
                .orElse(NO_MATCH);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    WinningType(int prize, int rank, int matchCount) {
        this.prize = prize;
        this.rank = rank;
        this.matchCount = matchCount;
    }
}