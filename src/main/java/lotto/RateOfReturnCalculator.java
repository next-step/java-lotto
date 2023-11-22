package lotto;

import static lotto.RewardPrice.*;

public class RateOfReturnCalculator {

    public RateOfReturnCalculator() {
    }

    public double calculateYield(int [] statistics, int money) {
        long totalPrize = statistics[MATCH_3.getCount()] * MATCH_3.getPrice()
                + statistics[MATCH_4.getCount()] * MATCH_4.getPrice()
                + statistics[MATCH_5.getCount()] * MATCH_5.getPrice()
                + statistics[MATCH_6.getCount()] * MATCH_6.getPrice();
        return (double) totalPrize / money;
    }
}
