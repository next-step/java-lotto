package domain;

import java.util.Map;

public class LottoProfit {
    private double profit;

    public LottoProfit(double profit) {
        this.profit = profit;
    }

    public static LottoProfit calculateProfit(Map<Integer, Integer> lottoStatistics, int price) {
        int prizeSum = lottoStatistics.keySet()
                .stream()
                .mapToInt(key -> key)
                .map(key -> lottoStatistics.get(key) * LottoPrize.valueOf(key).get(1))
                .sum();

        return new LottoProfit((double) prizeSum / (double) price);
    }

    public double getProfit() {
        return profit;
    }
}
