package lotto.data;

import java.util.Arrays;

import static lotto.util.ConstUtils.MINIMUM_WIN_MATCH;

public enum LottoWinInfo {
    WIN_FIRST(6, 2000000000),
    WIN_SECOND(5, 1500000),
    WIN_THIRD(4, 50000),
    WIN_FOURTH(3, 5000),
    PASS(0, 0)
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

    public static LottoWinInfo valueOf(int matchedCount) {
        if (matchedCount < MINIMUM_WIN_MATCH) {
            return PASS;
        }

        return Arrays.stream(values())
                .filter(win -> win.matchedCount == matchedCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
