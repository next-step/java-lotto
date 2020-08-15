package domain;

import java.math.BigDecimal;

public class LottoWinningMoney {
    private final BigDecimal money;

    public LottoWinningMoney(int money) {
        this.money = new BigDecimal(money);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public BigDecimal multiply(int winningNumber) {
        return money.multiply(new BigDecimal(winningNumber));
    }
}
