package step2.domain.lotto;

import java.util.Arrays;

public enum WinningCount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NO_MATCH(0, 0);

    private final long matchingCount;
    private final int winningAmount;

    public long getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    WinningCount(final long matchingCount, final int winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    private boolean isSameMatchingCount(final int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public static WinningCount findWinningCount(final int matchingCount) {
        return Arrays.stream(WinningCount.values())
                .filter(winningCount -> winningCount.isSameMatchingCount(matchingCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    @Override
    public String toString() {
        return this.matchingCount + "개 일치 (" + this.winningAmount + "원)";
    }
}
