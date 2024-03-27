package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;

public class Revenue {
    public double calculateRevenue(int money, long revenueTotal) {
        return (double)revenueTotal / money;
    }

    public long getRevenueTotal(HashMap<Integer, Integer> matchResult) {
        long total = 0;

        for (int prize : matchResult.keySet()) {
            total += (long) prize * matchResult.get(prize);
        }

        return total;
    }
}
