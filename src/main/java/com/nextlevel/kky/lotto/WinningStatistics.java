package com.nextlevel.kky.lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private static final double FIRST_REWARD = 2000000;
    private static final double SECOND_REWARD = 1500;
    private static final double THIRD_REWARD = 50;
    private static final double FOURTH_REWARD = 5;

    private final Map<Integer, Integer> winningMap;

    public double getAdvantageRate() {
        double count = winningMap.values().stream().mapToInt(Integer::intValue).sum();
        double firstAmount = winningMap.get(6) * FIRST_REWARD;
        double secondAmount = winningMap.get(5) * SECOND_REWARD;
        double thirdAmount = winningMap.get(4) * THIRD_REWARD;
        double fourthAmount = winningMap.get(3) * FOURTH_REWARD;
        return (firstAmount + secondAmount + thirdAmount + fourthAmount) / count;
    }

    public int getFirst() {
        return winningMap.get(6);
    }

    public int getSecond() {
        return winningMap.get(5);
    }

    public int getThird() {
        return winningMap.get(4);
    }

    public int getFourth() {
        return winningMap.get(3);
    }

    public Map<Integer, Integer> getWinningMap() {
        return winningMap;
    }

    public WinningStatistics() {
        winningMap = new HashMap<>();
        winningMap.put(0, 0);
        winningMap.put(1, 0);
        winningMap.put(2, 0);
        winningMap.put(3, 0);
        winningMap.put(4, 0);
        winningMap.put(5, 0);
        winningMap.put(6, 0);
    }
}
