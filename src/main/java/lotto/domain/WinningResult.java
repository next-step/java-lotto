package lotto.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.rank.Rank;

public class WinningResult {

    private static final int ZERO = 0;
    private static final int INCREASE = 1;

    private final Map<Rank, Integer> result;
    private long winningCash = 0;
    private float yield = 0;

    public WinningResult(List<Rank> ranks) {
        this.result = groupByRank(ranks);
    }

    private Map<Rank, Integer> groupByRank(List<Rank> ranks) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.NONE)
            .collect(Collectors.toMap(Function.identity(),
                rank -> resolveGroupByRank(ranks, rank),
                (p1, p2) -> p1,
                TreeMap::new));
    }

    private Integer resolveGroupByRank(List<Rank> ranks, Rank rank) {
        return ranks.stream()
            .filter(result -> result == rank)
            .map(result -> INCREASE)
            .reduce(ZERO, Integer::sum);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void calculateTotalPrize() {
        Iterator iterator = result.keySet().iterator();
        while (iterator.hasNext()) {
            Rank rank = (Rank) iterator.next();
            winningCash += result.get(rank) * rank.getPrize();
        }
    }

    public void calculateYield(int buyCash) {
        calculateTotalPrize();
        yield = (float) winningCash / buyCash;
    }

    public long getWinningCash() {
        return this.winningCash;
    }

    public float getYield() {
        return this.yield;
    }
}
