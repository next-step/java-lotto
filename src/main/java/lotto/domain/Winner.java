package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Winner {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int cash;

    Winner(int matchCount, int cash) {
        this.matchCount = matchCount;
        this.cash = cash;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getCash() {
        return cash;
    }

    public static Winner find(int matchCount) {
        return Arrays.stream(Winner.values())
                .filter(winner -> winner.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }

    public static Map<Winner, Integer> getWinnerMap() {
        Map<Winner, Integer> map = new HashMap<>();
        Arrays.stream(Winner.values())
                .filter(winner -> winner != Winner.NONE)
                .forEach(winner -> map.put(winner, 0));
        return map;
    }
}