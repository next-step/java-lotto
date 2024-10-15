package lotto.model.enums;

import java.util.Arrays;

public enum Ranking {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    ;

    private final int matchedCount;
    private final long winningAmount;

    Ranking(int matchedCount, long winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public static Ranking result(int matchedCount) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> Integer.valueOf(matchedCount).equals(ranking.matchedCount))
                .findFirst()
                .orElseGet(() -> Ranking.NONE);
    }

    public long totalWinningAmount(Integer winningCount) {
        return winningAmount * winningCount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public long winningAmount() {
        return winningAmount;
    }
}
