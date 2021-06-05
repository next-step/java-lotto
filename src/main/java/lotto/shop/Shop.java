package lotto.shop;

import lotto.error.ErrorMessage;

public class Shop {
    private static final int PURCHASE_PRICE = 1000;

    public Money buySelfLotto(Money money, int lottoQuantity) {
        checkMoney(money);
        return purchase(money, lottoQuantity);
    }

    public int buyAutoLotto(Money money) {
        checkMoney(money);
        return money.amount() / PURCHASE_PRICE;
    }

    private Money purchase(Money money, int quantity) {
        checkMoney(money);
        return new Money(calculate(money, quantity));
    }

    private void checkMoney(Money money) {
        if (money.amount() < PURCHASE_PRICE) {
            throw new RuntimeException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private void checkMoney(Money money, int quantity) {
        if (money.amount() < quantity * PURCHASE_PRICE) {
            throw new RuntimeException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private int calculate(Money money, int quantity) {
        checkMoney(money, quantity);
        return money.amount() - quantity * PURCHASE_PRICE;
    }
}