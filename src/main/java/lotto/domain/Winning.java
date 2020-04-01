package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOSE(0, 0);

    int matchCount;
    int winningPrice;

    private static Map<Integer, Winning> winningTypes;

    static {
        winningTypes = new HashMap<>();

        for (Winning winning : Winning.values()) {
            winningTypes.put(winning.getMatchCount(), winning);
        }
    }

    private int getMatchCount() {
        return matchCount;
    }

    public static Winning getWinningType(int matchCount) {
        if (matchCount < 3) {
            return LOSE;
        }

        return winningTypes.get(matchCount);
    }

    Winning(int matcheCount, int winningPrice) {
        this.matchCount = matcheCount;
        this.winningPrice = winningPrice;
    }
}
