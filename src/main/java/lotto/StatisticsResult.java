package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsResult {
    private final Map<Prize, Integer> prizeCount;
    private final double rateOfReturn;

    public StatisticsResult(final PurchaseHistory purchaseHistory, final Lotto previousWinningLotto) {
        this.prizeCount = calculatePrizeCount(purchaseHistory.getLottos(), previousWinningLotto);
        this.rateOfReturn = calculateRateOfReturn(purchaseHistory.getPayment());
    }

    private Map<Prize, Integer> calculatePrizeCount(List<Lotto> lottos, Lotto previousWinningLotto) {
        Map<Prize, Integer> temp = new HashMap<>();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.fromNumberOfMatch(lotto.countNumberOfMatch(previousWinningLotto));
            temp.put(prize, temp.getOrDefault(prize, 0) + 1);
        }
        return temp;
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
