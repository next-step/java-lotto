package step3;

import java.util.Arrays;

public enum WinningStatistics {
    WINING3(3, 5000),
    WINING4(4, 50000),
    WINING5(5, 1500000),
    WINING6(6, 2000000000);

    private int matchedNumberCount;
    private int winningPrice;

    WinningStatistics(int matchedNumberCount, int winningPrice) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningPrice = winningPrice;
    }

    public static WinningStatistics valueOfWinningCount(int winningCount) {
        return Arrays.stream(values()).filter(statistics -> statistics.matchedNumberCount == winningCount).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
