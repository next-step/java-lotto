package lotto.domain;

import java.math.BigDecimal;

public class LottoBuyer {

    private final BigDecimal amount;

    public LottoBuyer(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal payMoney() {
        return amount;
    }
}
