package domain;

import java.math.BigDecimal;

public class LottoMoney {
    public static final int MONEY_PER_GAME = 1000;

    private final BigDecimal money;

    public LottoMoney(int money) {
        validate(money);
        this.money = new BigDecimal(money);
    }

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해 주세요.");
        }
    }

    public BigDecimal getMoney() {
        return money;
    }
}
