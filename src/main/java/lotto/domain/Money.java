package lotto.domain;

import calculator.InvalidInputException;

public class Money {
    private static final String INVALID_LOTTO_PURCHASE_MONEY = "1000원이상 입력해야 로또 구매 가능합니다.";

    private int purchaseMoney;
    private int reward;

    public Money(int purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.reward = 0;
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney < 1000) {
            throw new InvalidInputException(INVALID_LOTTO_PURCHASE_MONEY);
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public void plusReward(int reward) {
        this.reward += reward;
    }

    public double getYield() {
        return reward * 1.0 / purchaseMoney;
    }
}
