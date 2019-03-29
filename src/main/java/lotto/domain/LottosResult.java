package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottosResult {
    public static final int DEFAULT_COUNT = 0;
    public static final int COUNT_UNIT = 1;
    private final Map<Prize, Integer> prizeCount = new HashMap<>();
    private double rateOfReturn;

    public LottosResult(Lottos purchasedLottos, WinningLotto previousWinningLotto) {
        initPrizeCount();
        setPrizeCount(purchasedLottos, previousWinningLotto);
        deleteNoPrize();
        setRateOfReturn(purchasedLottos);
    }

    private void deleteNoPrize() {
        prizeCount.remove(Prize.NO_PRIZE);
    }

    private void initPrizeCount() {
        Arrays.stream(Prize.values()).forEach(prize -> prizeCount.putIfAbsent(prize, DEFAULT_COUNT));
    }

    private void setPrizeCount(Lottos purchasedLottos, WinningLotto previousWinningLotto) {
        for (Lotto lotto : purchasedLottos.getLottos()) {
            Prize prize = Prize.valueOf(previousWinningLotto.countNumberOfMatch(lotto), previousWinningLotto.isAnyMatchingBonusBall(lotto));
            prizeCount.put(prize, prizeCount.get(prize) + COUNT_UNIT);
        }
    }

    private Money addTotalPrizeMoney() {
        return Money.addTotalPrizeMoney(prizeCount);
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private void setRateOfReturn(Lottos purchasedLottos) {
        Money payment = new Money(purchasedLottos.getSize() * Lotto.UNIT_PRICE);
        this.rateOfReturn = payment.calculateRateOfReturn(addTotalPrizeMoney());
    }
}
