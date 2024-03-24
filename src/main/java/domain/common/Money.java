package domain.common;

import utils.StringUtils;

import java.util.Objects;

public class Money {
    private final Long money;
    private final static long MINIMUM_MONEY = 0;

    public static Money from(String stringMoney) {
        assertBlankMoney(stringMoney);

        return from(Long.valueOf(stringMoney));
    }

    private static void assertBlankMoney(String stringMoney) {
        if (StringUtils.isBlank(stringMoney)) {
            throw new IllegalArgumentException("유효한 숫자만 Money를 생성할 수 있습니다.");
        }
    }

    public static Money from(long money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("0원 이하의 금액은 입력할 수 없습니다.");
        }
        return new Money(money);

    }

    public Money(long money) {
        this.money = money;
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

    public long divide(Money money) {
        return money.money() / this.money;
    }

    private long money() {
        return this.money;
    }

    public double divideDoubleMoneyToStringResult(Money money) {
        double result = money.money() / (double) this.money;
        return Math.floor(result * 100) / 100.0;
    }
}
