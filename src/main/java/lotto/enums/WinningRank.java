package lotto.enums;

import java.util.Arrays;

public enum WinningRank {
    FIRST_PLACE(1, 6, 2_000_000_000),
    SECOND_PLACE(2, 5, 1_500_000),
    THIRD_PLACE(3, 4, 50_000),
    FOURTH_PLACE(4, 3, 5_000),
    ETC(0, 0, 0);

    private final int rank;
    private final int matchedCount;
    private final int prize;

    WinningRank(int rank, int matchedCount, int prize) {
        this.rank = rank;
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static WinningRank findByMacthedCount(int matchedCount) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchedCount == matchedCount)
                .findAny()
                .orElse(ETC);
    }

    public int rank() {
        return rank;
    }

    public int prize() {
        return prize;
    }

    public int matchedCount() {
        return matchedCount;
    }
}
