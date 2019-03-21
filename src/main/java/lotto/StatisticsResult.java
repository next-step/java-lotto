package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsResult {
    public static final int DEFAULT_COUNT = 0;
    public static final int COUNT_UNIT = 1;
    private final Map<Prize, Integer> prizeCount;
    private final double rateOfReturn;

    public StatisticsResult(final PurchaseHistory purchaseHistory, final WinningLotto previousWinningLotto) {
        this.prizeCount = calculatePrizeCount(purchaseHistory.getLottos(), previousWinningLotto);
        this.rateOfReturn = calculateRateOfReturn(purchaseHistory.getPayment());
    }

    private Map<Prize, Integer> calculatePrizeCount(List<Lotto> lottos, WinningLotto previousWinningLotto) {
        Map<Prize, Integer> temp = new HashMap<>();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.fromNumberOfMatch(lotto.countNumberOfMatch(previousWinningLotto), lotto.isMatchingBonusBall(previousWinningLotto));
            temp.put(prize, temp.getOrDefault(prize, DEFAULT_COUNT) + COUNT_UNIT);
        }
        return temp;
    }

    private double calculateRateOfReturn(int payment) {
        long sum = 0L;
        for (Prize prize : Prize.values()) {
            sum += prize.calculatePrizeMoneyBy(prizeCount.getOrDefault(prize, DEFAULT_COUNT));
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
