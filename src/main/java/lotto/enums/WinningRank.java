package lotto.enums;

import lotto.domain.RanksCount;

import java.util.Arrays;
import java.util.Map;

public enum WinningRank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    ETC(0, 0);

    private final int matchedCount;
    private final int prize;

    WinningRank(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static WinningRank findByMacthedCount(int matchedCount) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchedCount == matchedCount)
                .findAny()
                .orElse(ETC);
    }

    public static int totalPrize(RanksCount ranksCount) {
        int totalPrize = 0;

        for (Map.Entry<WinningRank, Integer> rank : ranksCount.ranksCount().entrySet()) {
            totalPrize += rank.getKey().prize * rank.getValue();
        }

        return totalPrize;
    }

    public int prize() {
        return prize;
    }

    public int matchedCount() {
        return matchedCount;
    }
}
