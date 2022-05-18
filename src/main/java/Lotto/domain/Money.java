package Lotto.domain;

import Lotto.exception.TooSmallMoneyException;

public class Money {

    private static final int MIN_MONEY  = 1000;

    private int money = 0;

    public Money(int money, boolean isWinningMoney) {
        if (!isWinningMoney) {
            validate(money);
        }

        this.money = money;
    }

    public static Money createWinningMoney(int money) {
        return new Money(money, true);
    }

    private static void validate(int money) {
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
