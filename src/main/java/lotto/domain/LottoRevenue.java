package lotto.domain;

import java.util.HashMap;

public class LottoRevenue {
    public static double calculateRevenue(int money, long revenueTotal) {
        return (double) revenueTotal / money;
    }

    public static long revenueTotal(HashMap<Rank, Integer> result) {
        long total = 0;

        for (Rank rank : result.keySet()) {
            total += (long) result.get(rank) * rank.getPrize();
        }

        return total;
    }
}
