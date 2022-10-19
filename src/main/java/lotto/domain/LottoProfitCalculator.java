package lotto.domain;

import java.util.Map;

public class LottoProfitCalculator {

    private final int price;
    private final Map<Integer, Integer> result;

    public LottoProfitCalculator(int price, Map<Integer, Integer> result) {
        this.price = price;
        this.result = result;
    }


    public float calculate() {
        return (float) getTotalPrize(result) / price;
    }

    private static int getTotalPrize(Map<Integer, Integer> lottoResult) {
        int sum = 0;
        sum += Prize.THREE.getValue() * lottoResult.getOrDefault(3, 0);
        sum += Prize.FOUR.getValue() * lottoResult.getOrDefault(4, 0);
        sum += Prize.FIVE.getValue() * lottoResult.getOrDefault(5, 0);
        sum += Prize.SIX.getValue() * lottoResult.getOrDefault(6, 0);
        return sum;
    }
}
