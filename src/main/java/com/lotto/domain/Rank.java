package com.lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    LOSER(0, false, 0),
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    final private static Set<Integer> BONUS_MATCHING_COUNTS = Stream.of(values())
            .filter(rank -> rank.matchingBonus)
            .map(rank -> rank.matchingCount)
            .collect(Collectors.toSet());
    final private static int NO_WINNINGS_BENCHMARK = 0;
    final private int matchingCount;
    final private boolean matchingBonus;
    final private BigDecimal winnings;

    Rank(int matchingCount, boolean matchingBonus, int winnings) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
        this.winnings = new BigDecimal(winnings);
    }

    public static Rank matchRank(int matchingCount, boolean matchingBonus) {
        return Stream.of(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> !BONUS_MATCHING_COUNTS.contains(matchingCount) || rank.matchingBonus == matchingBonus)
                .findFirst()
                .orElse(LOSER);
    }

    public static Statistics calculateStatistics(List<Rank> ranks) {
        List<Statistic> statistics = Stream.of(values())
                .map(rank -> new Statistic(rank, ranks))
                .collect(Collectors.toList());
        return new Statistics(statistics);
    }

    public boolean hasWinnings() {
        return BigDecimal.ZERO.compareTo(winnings) < NO_WINNINGS_BENCHMARK;
    }

    public BigDecimal calculateTotalWinnings(int lotteryCount) {
        return winnings.multiply(new BigDecimal(lotteryCount));
    }

    public String toString(String format, String bonusFormat) {
        return String.format(matchingBonus ? bonusFormat : format, matchingCount, winnings);
    }
}
