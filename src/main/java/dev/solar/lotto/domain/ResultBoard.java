package dev.solar.lotto.domain;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeMap;

public class ResultBoard {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;

    private final TreeMap<Rank, Integer> winningResult;

    public ResultBoard() {
        this.winningResult = new TreeMap<>();
        initialWinningResult();
    }

    public void initialWinningResult() {
        Arrays.stream(Rank.values()).forEach(this::addKey);
    }

    private void addKey(Rank prizemoney) {
        this.winningResult.put(prizemoney, INITIAL_COUNT);
    }

    public void addResult(Rank rank) {
        winningResult.put(rank, winningResult.get(rank) + INCREASE_COUNT);
    }

    public Integer getValue(Rank rank) {
        return winningResult.get(rank);
    }

    public NavigableSet<Rank> getNavigableKeySet() {
        return winningResult.navigableKeySet();
    }
}
