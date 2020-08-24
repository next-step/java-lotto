package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class Winnings {

    private static final int DEFAULT_WINNING = 0;
    private static final Map<Integer, Integer> WINNING;

    static {
        WINNING = new HashMap<>();
        WINNING.put(3, 5000);
        WINNING.put(4, 50000);
        WINNING.put(5, 1500000);
        WINNING.put(6, 2000000000);
    }

    private Winnings() {

    }

    public static int calculateWinnings(int winningNumbersCount) {
        return WINNING.getOrDefault(winningNumbersCount, DEFAULT_WINNING);
    }
}
