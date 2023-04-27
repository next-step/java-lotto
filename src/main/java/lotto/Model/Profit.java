package lotto.Model;

import java.util.HashMap;

public class Profit {
    private static final int DEFAULT_PROFIT = 0;
    private final int profit;

    private static final HashMap<Integer, Integer> profitTable = new HashMap<>() {{
        put(3, 5_000);
        put(4, 50_000);
        put(5, 1_500_000);
        put(6, 2_000_000_000);
    }};

    public Profit(int matches) {
        profit = profitTable.getOrDefault(matches, DEFAULT_PROFIT);
    }

    public int value() {
        return profit;
    }
}
