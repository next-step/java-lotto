package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private static final int DEFAULT_BUY_COUNT = 0;
    private static final BigDecimal DEFAULT_MONEY = new BigDecimal(0);
    private static final int DIVIDE_SCALE = 3;

    private final BigDecimal money;

    public Money() {
        this(DEFAULT_MONEY);
    }

    public Money(long money) {
        this(new BigDecimal(money));
    }

    public Money(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public int countCanBuy(Money unitPrice) {
        if (unitPrice.isZero()) {
            return DEFAULT_BUY_COUNT;
        }

        return divide(unitPrice).intValue();
    }

    public BigDecimal calculateProfit(Money originalMoney) {
        return divide(originalMoney);
    }

    public Money multiply(int times) {
        return new Money(money.multiply(BigDecimal.valueOf(times)));
    }

    public Money add(Money other) {
        return new Money(money.add(other.money));
    }

    private BigDecimal divide(Money base) {
        if (base.isZero()) {
            return DEFAULT_MONEY;
        }

        return money.divide(
                base.money,
                DIVIDE_SCALE,
                RoundingMode.HALF_DOWN
        );
    }

    private boolean isZero() {
        return money.equals(DEFAULT_MONEY) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}
