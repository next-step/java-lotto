package lotto.data;

import java.util.Arrays;

public enum LottoWinInfo {
    WIN_FIRST(6, 2000000000),
    WIN_SECOND(5, 1500000),
    WIN_THIRD(4, 50000),
    WIN_FOURTH(3, 5000)
    ;

    private final int matchedCount;
    private final int winningPrice;

    LottoWinInfo(int matchedCount, int winningPrice) {
        this.matchedCount = matchedCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public LottoWinInfo valueOf(int matchedCount) {
        return Arrays.stream(values())
                .filter(win -> win.matchedCount == matchedCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
