package lotto.domain;

import java.math.BigDecimal;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class Money {
    private final BigDecimal money;

    Money(int money) {
        this.money = validate(money);
    }

    public BigDecimal validate(int money) {
        if (money < DEFAULT_GAME_PRICE) {
            throw new NotEnoughtMoneyException();
        }
        return new BigDecimal(money);
    }

    public Double getPaidTotal() {
        return money.doubleValue();
    }
}
