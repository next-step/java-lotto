package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<WinningRule, Integer> statistics;

    public Statistics() {
        this.statistics = new EnumMap<>(Map.of(
                WinningRule.THREE, 0,
                WinningRule.FOUR, 0,
                WinningRule.FIVE, 0,
                WinningRule.FIVE_BONUS, 0,
                WinningRule.SIX, 0
        ));
    }

    public int get(WinningRule key) {
        return statistics.get(key);
    }

    public void put(WinningRule key, int value) {
        this.statistics.put(key, value);
    }
}
