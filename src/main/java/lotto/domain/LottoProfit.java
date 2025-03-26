package lotto.domain;

import java.util.Map;

public class LottoProfit {
    public static Double calculate(Map<Integer, Integer> ranks, int totalCount) {
        long totalMoney = 0;

        for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
            int match = entry.getKey();
            int count = entry.getValue();
            LottoPrize prize = LottoPrize.from(match);
            totalMoney += (long) prize.getPrize() * count;
        }

        double result = totalMoney / (double) (totalCount * 1000);
        return Math.floor(result * 100) / 100.0;
    }
}


