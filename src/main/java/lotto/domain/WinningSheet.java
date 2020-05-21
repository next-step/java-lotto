package lotto.domain;

import java.util.Arrays;

public enum WinningSheet {
    FAIL(0, "0원"),
    FOURTH(3, "5000원"),
    THIRD(4, "50000원"),
    SECOND(5, "1500000원"),
    FIRST(6, "2000000000원");

    private final int matchCount;
    private final String price;

    WinningSheet(int matchCount, String price) {
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

    public String getPrice() {
        return price;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
