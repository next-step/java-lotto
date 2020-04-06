package lotto.domain.machine;

import java.math.BigDecimal;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoMoney {
    private final BigDecimal money;

    public LottoMoney(int money) {
        this.money = validate(money);
    }

    public BigDecimal validate(int money) {
        if (money < PRICE_PER_GAME) {
            throw new NotEnoughMoneyException();
        }
        return new BigDecimal(money);
    }

    public int getAvailableBuyingCount() {
        return Math.floorDiv(money.intValue(), PRICE_PER_GAME);
    }

}
