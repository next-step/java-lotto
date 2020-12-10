package com.nextstep.lotto;

import java.util.stream.Stream;

public enum LottoWinning {
    RETIRE(0, 0),
    WIN_5TH(3, 5_000),
    WIN_4TH(4, 50_000),
    WIN_3TH(5, 1_500_000),
    WIN_1TH(6, 2_000_000_000),
    ;

    private int matchedCount;
    private int winningPrice;

    private LottoWinning(int matchedCount, int winningPrice) {
        this.matchedCount = matchedCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static LottoWinning select(int matchedCount) {
        return Stream.of(LottoWinning.values())
                .filter(lottoWinning -> lottoWinning.matchedCount == matchedCount)
                .findFirst()
                .orElse(RETIRE);
    }
}
