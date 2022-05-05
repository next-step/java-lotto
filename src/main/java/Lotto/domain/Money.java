package Lotto.domain;

import Lotto.exception.TooSmallMoneyException;

public class Money {

    private int money = 0;
    private static final int MIN_MONEY  = 1000;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < MIN_MONEY) {
            throw new TooSmallMoneyException("구매금액은 최소" + MIN_MONEY + "이상이어야합니다.");
        }
    }

    public int changeMoneyToLottoNum() {
        return this.money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
