package lotto.model;

import java.util.Map;

public class Statistics {

    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;

    private final double totalPrice;
    private final double totalPrize;

    public Statistics(Count count, Map<Rank, Integer> totalRanks) {
        this.totalPrice = count.getCount() * PRICE_OF_A_LOTTO;
        this.totalPrize = calculateTotalPrize(totalRanks);
    }

    public double calculateBenefits() {
        return Math.floor((totalPrize / totalPrice) * HUNDRED) / HUNDRED;
    }

    private int calculateTotalPrize(Map<Rank, Integer> totalRanks) {
        int totalPrize = ZERO;
        for (Rank key : totalRanks.keySet()) {
            totalPrize += key.getReward() * totalRanks.get(key);
        }
        return totalPrize;
    }
}
