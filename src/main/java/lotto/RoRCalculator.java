package lotto;

import static lotto.RewardPrice.*;

public class RoRCalculator {

    private static final double LOTTO_PRICE = 1000.0;
    private RoRCalculator() {
    }

    public static double calculateYield(int [] statistics, int lottoCount) {
        long totalPrize = statistics[MATCH_3.getCount()] * MATCH_3.getPrice()
                + statistics[MATCH_4.getCount()] * MATCH_4.getPrice()
                + statistics[MATCH_5.getCount()] * MATCH_5.getPrice()
                + statistics[MATCH_6.getCount()] * MATCH_6.getPrice();
        return totalPrize / (lottoCount * LOTTO_PRICE);
    }
}
