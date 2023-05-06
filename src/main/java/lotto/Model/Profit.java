package lotto.Model;

import java.util.HashMap;

public class Profit {
    private static final int DEFAULT_PROFIT = 0;
    private final int profit;

    private static final HashMap<Integer, Integer> PROFIT_TABLE = new HashMap<>() {{
        // (rank, profit)
        put(5, 5_000);
        put(4, 50_000);
        put(3, 1_500_000);
        put(2, 30_000_000);
        put(1, 2_000_000_000);
    }};

    public Profit(int matches) {
        profit = PROFIT_TABLE.getOrDefault(matches, DEFAULT_PROFIT);
    }

    public int value() {
        return profit;
    }
}
