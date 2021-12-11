package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    ETC(0, 0);

    private final int matchedCount;
    private final int winningAmount;

    private Rank(int matchedCount, int winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int winningAmount() {
        return winningAmount;
    }

    public static int winningAmount(int matchedCount) {
        return getRank(matchedCount).winningAmount;
    }

    private static Rank getRank(int matchedCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst().orElse(Rank.ETC);
    }

}