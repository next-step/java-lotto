package lotto;

import java.util.Map;

public class StatisticsResult {
    private final Map<Prize, Integer> prizeCount;
    private final double rateOfReturn;

    public StatisticsResult(final int payment, final Map<Prize, Integer> prizeCount) {
        this.prizeCount = prizeCount;
        this.rateOfReturn = calculateRateOfReturn(payment);
    }

    private double calculateRateOfReturn(int payment) {
        long sum = 0L;
        for (Prize prize : Prize.values()) {
            sum += prize.calculatePrizeMoneyBy(prizeCount.getOrDefault(prize, 0));
        }
        return sum / (double) payment;
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
