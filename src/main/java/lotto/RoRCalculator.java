package lotto;

import static lotto.RewardPrice.*;

public class RoRCalculator {

    private static final double LOTTO_PRICE = 1000.0;
    private RoRCalculator() {
    }

    public static double calculateYield(int[] statistics, int lottoCount) {
        long totalPrize = statistics[0] * MATCH_3.getPrice()
                + statistics[1] * MATCH_4.getPrice()
                + statistics[2] * MATCH_5.getPrice()
                + statistics[3] * MATCH_6.getPrice();
        return round2DecimalPlaces(totalPrize / (lottoCount * LOTTO_PRICE) * 100.0);
    }

    private static double round2DecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
