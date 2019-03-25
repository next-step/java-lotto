package lotto.domain;

import java.util.Arrays;

public enum WinningType {
    NO_MATCH(0, 0, 0),
    FOURTH(5000, 4, 3),
    THIRD(50000, 3, 4),
    SECOND(1500000, 2, 5),
    FIRST(2000000000, 1, 6);

    private int prize;
    private int rank;
    private int matchCount;

    public static final int MATCH_COUNT_THREE = 3;
    public static final int MATCH_COUNT_FOUR = 4;
    public static final int MATCH_COUNT_FIVE = 5;
    public static final int MATCH_COUNT_SIX = 6;

    public int getPrize() {
        return prize;
    }

    public static int getPrize(int matchCount) {
        return findByMatchCount(matchCount).getPrize();
    }

    public static int getRank(int matchCount) {
        return findByMatchCount(matchCount).getRank();
    }

    private static WinningType findByMatchCount(int matchCount) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchCount == matchCount)
                .findAny()
                .orElse(NO_MATCH);
    }

    public int getRank() {
        return rank;
    }

    WinningType(int prize, int rank, int matchCount) {
        this.prize = prize;
        this.rank = rank;
        this.matchCount = matchCount;
    }
}