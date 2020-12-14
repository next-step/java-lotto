package com.jaenyeong.mission02.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    //    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningPrize;

    Rank(final int countOfMatch, final int winningPrize) {
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static Rank valueOf(final int countOfMatch) {
        return Arrays.stream(values())
            .filter(rank -> compareCountOfMatch(countOfMatch, rank))
            .findFirst()
            .orElse(MISS);
    }

    private static boolean compareCountOfMatch(final int countOfMatch, final Rank rank) {
        return countOfMatch == rank.countOfMatch;
    }

    public boolean isNotMissMatch() {
        return this != MISS;
    }

//    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
//        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
//        return null;
//    }
}
