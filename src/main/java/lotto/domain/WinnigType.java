package lotto.domain;

import java.util.Arrays;

public enum WinnigType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final long matchCnt;
    private final int winningAmount;

    WinnigType(long matchCnt, int winningAmount) {
        this.matchCnt = matchCnt;
        this.winningAmount = winningAmount;
    }

    public static WinnigType of(long lottoMatchCnt) {
        return Arrays.stream(values())
                .filter(winnigType -> winnigType.matchCnt == lottoMatchCnt)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public long getMatchCnt() {
        return matchCnt;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
