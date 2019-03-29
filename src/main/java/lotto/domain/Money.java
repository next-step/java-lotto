package lotto.domain;

import java.util.Map;

public class Money {
    public static int ZERO = 0;
    private int amount;

    public Money(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException("금액은 음수 또는 0일 수 없습니다.");
        }
        this.amount = amount;
    }

    public static Money addTotalPrizeMoney(Map<Prize, Integer> prizeCount) {
        return new Money(prizeCount.keySet()
                .stream()
                .map(prize -> prize.calculatePrizeMoneyBy(prizeCount.get(prize)))
                .reduce(0, (x, y) -> x + y));
    }

    public boolean isNotEnoughForPurchase() {
        return amount < Lotto.UNIT_PRICE;
    }

    public int calculateNumberOfLottoAvailableForPurchase() {
        return amount / Lotto.UNIT_PRICE;
    }

    public double calculateRateOfReturn(Money profit) {
        return profit.amount / (double) amount;
    }
}
