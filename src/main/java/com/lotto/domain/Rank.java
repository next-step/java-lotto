package com.lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Rank {
    LOSER(0, false, 0),
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    final private static Set<Integer> BONUS_MATCHING_COUNTS = Arrays.stream(values())
            .filter(rank -> rank.matchingBonus)
            .map(rank -> rank.matchingCount)
            .collect(Collectors.toSet());
    final private int matchingCount;
    final private boolean matchingBonus;
    final private BigDecimal winnings;

    Rank(int matchingCount, boolean matchingBonus, int winnings) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
        this.winnings = new BigDecimal(winnings);
    }

    public static Rank matchRank(int matchingCount, boolean matchingBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> !BONUS_MATCHING_COUNTS.contains(matchingCount) || rank.matchingBonus == matchingBonus)
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

    public String toString(String format, String bonusFormat) {
        return String.format(matchingBonus ? bonusFormat : format, matchingCount, winnings);
    }
}
