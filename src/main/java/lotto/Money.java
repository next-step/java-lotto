package lotto;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
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
