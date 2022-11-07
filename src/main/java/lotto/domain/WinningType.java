package lotto.domain;

import java.util.Arrays;

public enum WinningType {

    NOT_WINNING(0, 0),
    FOURTH_PLACE(3, 5_000),
    THIRD_PLACE(4, 50_000),
    SECOND_PLACE(5, 1_500_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final long matchCnt;
    private final int winningAmount;

    WinningType(long matchCnt, int winningAmount) {
        this.matchCnt = matchCnt;
        this.winningAmount = winningAmount;
    }

    public static WinningType of(long lottoMatchCnt) {
        return Arrays.stream(values())
                .filter(winningType -> winningType.matchCnt == lottoMatchCnt)
                .findFirst()
                .orElse(NOT_WINNING);
    }

    public long getMatchCnt() {
        return matchCnt;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
