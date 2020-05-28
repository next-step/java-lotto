package lotto.vo;

import java.util.HashMap;
import java.util.Map;

public class Money {
    private static final Map<Long, Money> CACHE = new HashMap<>();
    private final long value;

    public Money(final long value) {
        this.value = value;
    }

    public static Money of(final long value) {
        return CACHE.computeIfAbsent(value, Money::new);
    }

    public Money spend(final Money money) {
        if (money.value == 0) {
            return this;
        }
        return Money.of(this.value - money.value);
    }

    public Money add(final Money money) {
        if (money.value == 0) {
            return this;
        }
        return Money.of(this.value + money.value);
    }

    public Money multiply(final int count) {
        return Money.of(value * count);
    }

    public double calculateYield(Money expenditure) {
        return (double) this.value / expenditure.value;
    }

    public boolean isEnoughToBuy(final Money price) {
        return this.value >= price.value;
    }
}
