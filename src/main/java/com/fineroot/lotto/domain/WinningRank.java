package com.fineroot.lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    FORTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winnerPrice;

    WinningRank(int matchCount, int winnerPrice) {
        this.matchCount = matchCount;
        this.winnerPrice = winnerPrice;
    }

    public static WinningRank of(int matchCount) {
        return Arrays.stream(WinningRank.values())
                .filter(policy -> policy.matchCount == matchCount)
                .findFirst()
                .orElse(WinningRank.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

}
