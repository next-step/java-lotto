package com.fineroot.lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    FIFTH_PRIZE(3, 5_000),
    FORTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),

    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winnerPrice;

    WinningRank(int matchCount, int winnerPrice) {
        this.matchCount = matchCount;
        this.winnerPrice = winnerPrice;
    }

    public static WinningRank valueOf(int matchCount, boolean hasBonus){
        if(isSecond(matchCount, hasBonus)){
            return WinningRank.SECOND_PRIZE;
        }
        return Arrays.stream(WinningRank.values())
                .filter(rank->rank.matchCount==matchCount)
                .findFirst()
                .orElse(WinningRank.NONE);
    }

    private static boolean isSecond(int matchCount, boolean hasBonus) {
        return matchCount == 5 && hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

}
