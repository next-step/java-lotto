package dev.solar.lotto.domain;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Rank {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;

    private final TreeMap<PrizeMoney, Integer> winningResult;

    public Rank() {
        this.winningResult = new TreeMap<>();
        initialWinningResult();
    }

    public void initialWinningResult() {
        Arrays.stream(PrizeMoney.values()).forEach(this::addKey);
    }

    private void addKey(PrizeMoney prizemoney) {
        this.winningResult.put(prizemoney, INITIAL_COUNT);
    }

    public void addResult(int matchResult) {
        final PrizeMoney rank = PrizeMoney.rank(matchResult);
        winningResult.put(rank, winningResult.get(rank) + INCREASE_COUNT);
    }

    public Integer getValue(PrizeMoney prizeMoney) {
        return winningResult.get(prizeMoney);
    }

    public NavigableSet<PrizeMoney> getNavigableKeySet() {
        return winningResult.navigableKeySet();
    }
}
