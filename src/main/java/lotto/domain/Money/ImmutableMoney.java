package lotto.domain.Money;

import java.util.Objects;

public class ImmutableMoney {

    protected long money;
    protected static final int MONEY_MINIMUM = 0;

    protected final static String MONEY_NEGATIVE_EXCEPTION = "Money에는 " + MONEY_MINIMUM + "이상의 값만 들어올 수 있습니다.";

    public ImmutableMoney(long money) {
        if (money < MONEY_MINIMUM) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_EXCEPTION);
        }
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass() && o.getClass() != Money.class)) return false;
        ImmutableMoney that = (ImmutableMoney) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
