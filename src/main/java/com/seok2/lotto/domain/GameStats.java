package com.seok2.lotto.domain;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameStats {

    private final List<Rank> stats;

    private GameStats(List<Rank> stats) {
        this.stats = stats;
    }

    public static GameStats of(List<Rank> stats) {
        return new GameStats(stats);
    }

    private long count(Rank rank) {
        return stats.stream()
            .filter(rank::equals)
            .count();
    }

    public Money getTotalReward() {
        return stats
            .stream()
            .map(Rank::getReward)
            .reduce(Money::add)
            .get();
    }

    public Profit getProfit(Money investment) {
        return getTotalReward().calculateProfit(investment);
    }
}
