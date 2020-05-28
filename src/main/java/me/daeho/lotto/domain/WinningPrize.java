package me.daeho.lotto.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningPrize {
    private final Map<Integer, Integer> prizes = new HashMap<>();

    private WinningPrize() {
    }

    public static WinningPrize create() {
        return new WinningPrize();
    }

    public WinningPrize setting(int count, int prize) {
        prizes.putIfAbsent(count, prize);
        return this;
    }

    public int prize(int count) {
        return prizes.getOrDefault(count, 0);
    }

    public int size() {
        return prizes.size();
    }

    public Collection<Integer> winningCounts() {
        return prizes.keySet();
    }
}
