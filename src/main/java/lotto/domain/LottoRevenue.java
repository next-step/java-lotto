package lotto.domain;

import java.util.HashMap;

public class LottoRevenue {
    public double calculateRevenue(int money, long revenueTotal) {
        return (double) revenueTotal / money;
    }

    public long revenueTotal(HashMap<Rank, Integer> result) {
        long total = 0;

        for (Rank rank : result.keySet()) {
            total += (long) result.get(rank) * rank.getPrize();
        }

        return total;
    }
}
