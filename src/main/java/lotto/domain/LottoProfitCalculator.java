package lotto.domain;

import java.util.Map;

public class LottoProfitCalculator {

    public float calculate(int price, Map<Prize, Integer> result) {
        return (float) getTotalPrize(result) / price;
    }

    private static int getTotalPrize(Map<Prize, Integer> lottoResult) {
        int sum = 0;
        for (Prize prize: Prize.values()) {
            sum += prize.getValue() * lottoResult.getOrDefault(prize, 0);
        }
        return sum;
    }
}
