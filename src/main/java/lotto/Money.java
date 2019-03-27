package lotto;

import java.util.Map;

public class Money {
    private int amount;

    public Money(int amount) {
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
