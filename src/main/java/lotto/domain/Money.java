package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private static final int DEFAULT_DECIMAL_POINT = 2;
    private final int money;

    public Money(int inputAmount) {
        validate(inputAmount);
        this.money = inputAmount;
    }

    public int getMoney() {
        return this.money;
    }

    public BigDecimal calcReturnRate(Money otherMoney) {
        return returnBigDecimalType()
                .divide(otherMoney.returnBigDecimalType(), DEFAULT_DECIMAL_POINT, RoundingMode.HALF_UP);
    }
    private void validate(int inputAmount) {
        if (inputAmount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private BigDecimal returnBigDecimalType() {
        return BigDecimal.valueOf(this.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
