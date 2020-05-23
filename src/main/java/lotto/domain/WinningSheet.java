package lotto.domain;

import java.util.Arrays;

public enum WinningSheet {
    FAIL(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int price;

    WinningSheet(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static WinningSheet findByMatchCount(int matchCount) {
        return Arrays.stream(WinningSheet.values())
                .filter(winningSheet -> winningSheet.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(WinningSheet.FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
