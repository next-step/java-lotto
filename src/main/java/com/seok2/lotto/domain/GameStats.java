package com.seok2.lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameStats {
    private static final long ZERO = 0;
    private final Map<Rank, Long> stats;

    private GameStats(List<Rank> stats) {
        this.stats = stats.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static GameStats of(List<Rank> stats) {
        return new GameStats(stats);
    }

    public long getNumberOfWins(Rank rank) {
        return stats.getOrDefault(rank, ZERO);
    }

    public Money getTotalWinnings() {
        return stats.entrySet()
                .stream()
                .map(e -> e.getKey().getWinnings(e.getValue().intValue()))
                .reduce(Money::add)
                .get();
    }

    public Profit getProfit(Money investment) {
        return getTotalWinnings().calculateProfit(investment);
    }
}
