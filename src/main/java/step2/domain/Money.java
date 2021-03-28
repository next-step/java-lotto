package step2.domain;

import step2.constants.Constants;

public class Money {
    private int money;

    private Money(final int amount) {
        this.money = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    public boolean isPossibleBuyLotto(int purchaseCount) {
        return money >= (Constants.LOTTO_PRICE * purchaseCount);
    }

    public double getRevenueRate(int totalPrizeAmount) {
        return (double) totalPrizeAmount / money;
    }
}
