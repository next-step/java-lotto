package lotto.model;

import static lotto.Messages.WARNING_NOT_ENOUGH_TO_BUY;

public class Money {
    private static final int MONEY_TO_BUY_ONE_LOTTO = 1000;

    private int money;

    public Money(int money) {
        validateEnoughMoneyToBuy(isEnoughMoneyToBuy(money));
        this.money = money;
    }

    private static boolean isEnoughMoneyToBuy(int money) {
        return money >= MONEY_TO_BUY_ONE_LOTTO;
    }

    private static void validateEnoughMoneyToBuy(boolean isGreaterThan1000) {
        if (!isGreaterThan1000) {
            throw new IllegalArgumentException(WARNING_NOT_ENOUGH_TO_BUY);
        }
    }

    public int getLottoCount() {
        return (money / MONEY_TO_BUY_ONE_LOTTO);
    }
}