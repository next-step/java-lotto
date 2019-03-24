package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottosResult {
    public static final int DEFAULT_COUNT = 0;
    public static final int COUNT_UNIT = 1;
    private final Map<Prize, Integer> prizeCount;
    private final double rateOfReturn;

    public LottosResult(PurchasedLottos purchasedLottos, WinningLotto previousWinningLotto, Money payment) {
        this.prizeCount = calculatePrizeCount(purchasedLottos, previousWinningLotto);
        this.rateOfReturn = calculateRateOfReturn(payment);
    }

    private Map<Prize, Integer> calculatePrizeCount(PurchasedLottos purchasedLottos, WinningLotto previousWinningLotto) {
        Map<Prize, Integer> temp = new HashMap<>();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            Prize prize = Prize.valueOf(previousWinningLotto.countNumberOfMatch(lotto), previousWinningLotto.isAnyMatchingBonusBall(lotto));
            temp.put(prize, temp.getOrDefault(prize, DEFAULT_COUNT) + COUNT_UNIT);
        }
        return temp;
    }

    private Money addTotalPrizeMoney() {
        return new Money(prizeCount.keySet()
                .stream()
                .map(prize -> prize.calculatePrizeMoneyBy(prizeCount.get(prize)))
                .reduce(0, (x, y) -> x + y));
    }

    private double calculateRateOfReturn(Money payment) {
        return payment.calculateRateOfReturn(addTotalPrizeMoney());
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
