package lotto.domain;

import java.math.BigDecimal;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoMoney {
    private final BigDecimal money;

    LottoMoney(int money) {
        this.money = validate(money);
    }

    public BigDecimal validate(int money) {
        if (money < DEFAULT_GAME_PRICE) {
            throw new NotEnoughMoneyException();
        }
        return new BigDecimal(money);
    }

    public int getAvailableBuyingCount() {
        return Math.floorDiv(money.intValue(), DEFAULT_GAME_PRICE);
    }

    public Double getPaidTotal() {
        return money.doubleValue();
    }

    public int convertToInt() {
        return money.intValue();
    }
}
