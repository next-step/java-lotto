package lotto.domain;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class Money {
    private final int money;

    private Money(int money) {
        this.money = validate(money);
    }

    public static int validate(int money) {
        if (money < DEFAULT_GAME_PRICE) {
            throw new NotEnoughtMoneyException();
        }
        return money;
    }
}
