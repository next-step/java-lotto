package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottosResult {
    public static final int DEFAULT_COUNT = 0;
    public static final int COUNT_UNIT = 1;
    private final Map<Prize, Integer> prizeCount;
    private double rateOfReturn;

    public LottosResult(Lottos purchasedLottos, WinningLotto previousWinningLotto, LottoOrder lottoOrder) {
        this.prizeCount = calculatePrizeCount(purchasedLottos, previousWinningLotto);
        this.rateOfReturn = calculateRateOfReturn(lottoOrder);
    }

    private Map<Prize, Integer> calculatePrizeCount(Lottos purchasedLottos, WinningLotto previousWinningLotto) {
        Map<Prize, Integer> temp = new HashMap<>();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            Prize prize = Prize.valueOf(previousWinningLotto.countNumberOfMatch(lotto), previousWinningLotto.isAnyMatchingBonusBall(lotto));
            temp.put(prize, temp.getOrDefault(prize, DEFAULT_COUNT) + COUNT_UNIT);
        }
        return temp;
    }

    private Money addTotalPrizeMoney() {
        return Money.addTotalPrizeMoney(prizeCount);
    }

    private double calculateRateOfReturn(LottoOrder lottoOrder) {
        return lottoOrder.calculateRateOfReturn(addTotalPrizeMoney());
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
