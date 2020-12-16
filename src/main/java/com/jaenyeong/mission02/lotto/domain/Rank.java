package com.jaenyeong.mission02.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "%d개 일치 (%d원) - %d개"),
    SECOND(5, 30_000_000, "%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    THIRD(5, 1_500_000, "%d개 일치 (%d원) - %d개"),
    FOURTH(4, 50_000, "%d개 일치 (%d원) - %d개"),
    FIFTH(3, 5_000, "%d개 일치 (%d원) - %d개"),
    MISS(0, 0, "MISS");

    private static final int NUMBER_OF_SECOND_WINNING = 5;
    private final String printFormat;
    private final int countOfMatch;
    private final int winningPrize;

    Rank(final int countOfMatch, final int winningPrize, final String printFormat) {
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
        this.printFormat = printFormat;
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

    public static Rank valueOf(final int countOfMatch, final boolean matchBonus) {
        return Arrays.stream(values())
            .filter(rank -> compareCountOfMatch(countOfMatch, rank))
            .map(rank -> {
                if (isMatchingNumberEqualsFive(rank)) {
                    return getSecondAndThirdRank(matchBonus);
                }
                return rank;
            })
            .findFirst()
            .orElse(MISS);
    }

    private static Rank getSecondAndThirdRank(final boolean matchBonus) {
        return matchBonus ? SECOND : THIRD;
    }

    private static boolean isMatchingNumberEqualsFive(final Rank rank) {
        return rank.countOfMatch == NUMBER_OF_SECOND_WINNING;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public String getPrintFormat() {
        return printFormat;
    }
}
