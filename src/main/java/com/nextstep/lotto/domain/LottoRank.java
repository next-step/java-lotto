package com.nextstep.lotto.domain;

import java.util.stream.Stream;

public enum LottoRank {
    RETIRE(0, 0),
    WIN_5TH(3, 5_000),
    WIN_4TH(4, 50_000),
    WIN_3RD(5, 1_500_000) {
        @Override
        protected boolean isMatched(long matchedCount, boolean matchedBonus) {
            return this.matchedCount == matchedCount && !matchedBonus;
        }
    },
    WIN_2ND(5, 30_000_000) {
        @Override
        protected boolean isMatched(long matchedCount, boolean matchedBonus) {
            return this.matchedCount == matchedCount && matchedBonus;
        }
    },
    WIN_1ST(6, 2_000_000_000),
    ;

    protected final int matchedCount;
    private final int winningPrice;

    LottoRank(int matchedCount, int winningPrice) {
        this.matchedCount = matchedCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static LottoRank select(long matchedCount, boolean matchedBonus) {
        return Stream.of(LottoRank.values())
                .filter(lottoWinning -> lottoWinning.isMatched(matchedCount, matchedBonus))
                .findFirst()
                .orElse(RETIRE);
    }

    protected boolean isMatched(long matchedCount, boolean matchedBonus) {
        return this.matchedCount == matchedCount;
    }
}
