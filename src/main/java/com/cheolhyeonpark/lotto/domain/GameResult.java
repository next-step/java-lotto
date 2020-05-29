package com.cheolhyeonpark.lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Rank, Integer> rankCount = new HashMap<>();

    public void count(Rank rank) {
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

    private int getTotalPrice() {
        return Arrays.stream(Rank.values()).mapToInt(rank -> rank.getPrice() * getCount(rank)).sum();
    }

    public double getYields(int amount) {
        return (double) getTotalPrice() / amount;
    }
}
