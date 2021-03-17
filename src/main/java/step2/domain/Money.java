package step2.domain;

import java.math.BigDecimal;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int money;

    public Money(int money) {
        if (money % LOTTO_PRICE != ZERO || money == ZERO) {
            throw new IllegalArgumentException("1000원 단위로 돈을 지불해주세요");
        }
        this.money = money;
    }

    public int toInt() {
        return money;
    }

    public int divideMoneyByPrice() {
        return BigDecimal.valueOf(money)
                .divide(BigDecimal.valueOf(LOTTO_PRICE))
                .intValue();
    }
}
