package com.nextstep.lotto.domain;

import java.util.stream.Stream;

public enum LottoWinning {
    RETIRE(0, 0),
    WIN_5TH(3, 5_000),
    WIN_4TH(4, 50_000),
    WIN_3RD(5, 1_500_000),
    WIN_1ST(6, 2_000_000_000),
    ;

    private final int matchedCount;
    private final int winningPrice;

    LottoWinning(int matchedCount, int winningPrice) {
        this.matchedCount = matchedCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static LottoWinning select(long matchedCount) {
        return Stream.of(LottoWinning.values())
                .filter(lottoWinning -> lottoWinning.matchedCount == matchedCount)
                .findFirst()
                .orElse(RETIRE);
    }
}
