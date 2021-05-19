package lotto.domain;

import java.util.Map;

public class LottoResult {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;
    private final Map<Prize, Integer> result;

    public LottoResult(Map<Prize, Integer> result) {
        this.result = result;
    }

    public int prizeCount(Prize prize) {
        return result.getOrDefault(prize, ZERO);
    }

    public double calculateProfitRate(int price) {
        int profit = ZERO;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            profit += entry.getKey().calculateProfit(entry.getValue());
        }
        return Math.floor((double) profit / price * HUNDRED) / HUNDRED ;
    }
}
