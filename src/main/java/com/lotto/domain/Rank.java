package com.lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    LOSER(0, 0),
    FORTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    final private int matchingCount;
    final private BigDecimal winnings;

    Rank(int matchingCount, int winnings) {
        this.matchingCount = matchingCount;
        this.winnings = new BigDecimal(winnings);
    }

    public static Rank matchRank(int matchingCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .findFirst()
                .orElse(LOSER);
    }

    public static List<Statistic> makeStatistics(List<Rank> ranks) {
        return Arrays.stream(values())
                .filter(rank -> rank != LOSER)
                .map(rank -> new Statistic(rank, ranks))
                .collect(Collectors.toList());
    }

    public BigDecimal calculateTotalWinnings(int lotteryCount) {
        return winnings.multiply(new BigDecimal(lotteryCount));
    }

    public String toString(String format) {
        return String.format(format, matchingCount, winnings);
    }
}
