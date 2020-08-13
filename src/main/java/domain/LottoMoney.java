package domain;

import java.math.BigDecimal;

public class LottoMoney {
    public static final BigDecimal MONEY_PER_GAME = new BigDecimal(1000);

    private final BigDecimal money;

    public LottoMoney(int money) {
        this.money = new BigDecimal(money);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public BigDecimal multiply(int winningNumber) {
        return money.multiply(new BigDecimal(winningNumber));
    }
}
