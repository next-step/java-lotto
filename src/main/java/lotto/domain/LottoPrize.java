package lotto.domain;

import java.util.Arrays;
import static lotto.io.OutputView.*;

public enum LottoPrize {

    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0)
    ;

    public final int matchCount;
    public final int matchPrize;
    private int winningCount;
    private long winningPrize;

    LottoPrize(int matchCount, int matchPrize) {
        this.matchCount = matchCount;
        this.matchPrize = matchPrize;
    }

    void updateWinningResult(int matchCount) {
        if (this.matchCount == matchCount) {
            this.winningCount++;
            this.winningPrize += this.matchPrize;
        }
    }

    static LottoPrize findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }

    public static long getTotalPrize() {
        long total = 0;
        for (LottoPrize prize : values()) {
            total += prize.winningPrize;
        }
        return total;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public long getWinningPrize() {
        return winningPrize;
    }

    public void setWinningCount(int winningCount) {
        this.winningCount = winningCount;
    }

    public void setWinningPrize(long winningPrize) {
        this.winningPrize = winningPrize;
    }

    public static void printResult() {
        for (LottoPrize prize : values()) {
            printLottoPrize(prize);
        }
    }
}
