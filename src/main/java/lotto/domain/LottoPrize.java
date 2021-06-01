package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0)
    ;

    final int matchCount;
    final int matchPrize;
    private int totalWinningCount;
    private long totalWinningPrize;

    LottoPrize(int matchCount, int matchPrize) {
        this.matchCount = matchCount;
        this.matchPrize = matchPrize;
    }

    void updateWinningResult(int matchCount) {
        if (this.matchCount == matchCount) {
            this.totalWinningCount++;
            this.totalWinningPrize += this.matchPrize;
        }
    }

    static LottoPrize findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }

    public int getTotalWinningCount() {
        return totalWinningCount;
    }

    public long getTotalWinningPrize() {
        return totalWinningPrize;
    }

}
