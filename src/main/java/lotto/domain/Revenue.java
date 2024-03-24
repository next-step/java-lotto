package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;

public class Revenue {
    public double calculate(int money, int revenueTotal) {
        return (double)revenueTotal / money;
    }

    public int getRevenueTotal(HashMap<Integer, Integer> matchResult) {
        int total = 0;

        for (int prize : matchResult.keySet()) {
            total += prize * matchResult.get(prize);
        }

        return total;
    }
}
