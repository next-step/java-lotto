package step2.domain;

import java.util.Arrays;

public enum WinningCount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final long matchingCount;
    private final int winningAmount;

    public long getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    WinningCount(long matchingCount, int winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    public static WinningCount findWinningCount(long matchingCount) {
        return Arrays.stream(WinningCount.values())
                .filter(winningCount -> winningCount.getMatchingCount() == matchingCount).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효한 당첨 숫자 개수가 아닙니다."));
    }
}
