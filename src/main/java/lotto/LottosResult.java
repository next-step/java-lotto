package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottosResult {
    public static final int DEFAULT_COUNT = 0;
    public static final int COUNT_UNIT = 1;
    private final Map<Prize, Integer> prizeCount = new HashMap<>();
    private double rateOfReturn;

    public LottosResult(Lottos purchasedLottos, WinningLotto previousWinningLotto, Money payment) {
        setPrizeCount(purchasedLottos, previousWinningLotto);
        setRateOfReturn(payment);
    }

    private void setPrizeCount(Lottos purchasedLottos, WinningLotto previousWinningLotto) {
        for (Lotto lotto : purchasedLottos.getLottos()) {
            Prize prize = Prize.valueOf(previousWinningLotto.countNumberOfMatch(lotto), previousWinningLotto.isAnyMatchingBonusBall(lotto));
            prizeCount.put(prize, prizeCount.getOrDefault(prize, DEFAULT_COUNT) + COUNT_UNIT);
        }
    }

    private Money addTotalPrizeMoney() {
        return Money.addTotalPrizeMoney(prizeCount);
    }

    private void setRateOfReturn(Money payment) {
        this.rateOfReturn = payment.calculateRateOfReturn(addTotalPrizeMoney());
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
