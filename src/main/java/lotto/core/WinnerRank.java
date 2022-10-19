package lotto.core;

import java.util.HashMap;
import java.util.Map;

public enum WinnerRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000);

    private final int correctNumberCount;
    private final int award;

    private static final Map<Integer, WinnerRank> BY_CORRECT_NUMBER_COUNT = new HashMap<>();

    static {
        for (WinnerRank winnerRank : values()) {
            BY_CORRECT_NUMBER_COUNT.put(winnerRank.correctNumberCount, winnerRank);
        }
    }

    WinnerRank(int correctNumberCount, int award) {
        this.correctNumberCount = correctNumberCount;
        this.award = award;
    }

    public static WinnerRank fromCount(int count) {
        if (!BY_CORRECT_NUMBER_COUNT.containsKey(count)) {
            throw new IllegalArgumentException("No winner rank matched with the count");
        }
        return BY_CORRECT_NUMBER_COUNT.get(count);
    }

    public int getAward() {
        return award;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }
}
