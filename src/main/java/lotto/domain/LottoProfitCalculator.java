package lotto.domain;

import java.util.Map;

public class LottoProfitCalculator {

    private final int price;
    private final Map<Prize, Integer> result;

    public LottoProfitCalculator(int price, Map<Prize, Integer> result) {
        this.price = price;
        this.result = result;
    }


    public float calculate() {
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
