package lotto.domain.shop;

import lotto.domain.shop.exceptions.OnlyTenThousandsException;
import lotto.domain.shop.exceptions.OutOfBoundMoneyCreationException;

import java.util.Objects;

public class Money {
    private final static long MIN_VALUE = 0L;
    private final static long MAX_VALUE = 100_000L;
    private long value;

    public Money(long value) {
        validation(value);
        this.value = value;
    }

    private void validation(long value) {
        if (value <= MIN_VALUE || value > MAX_VALUE) {
            throw new OutOfBoundMoneyCreationException("Input value is too big or small");
        }
        if (value % 1000 != 0) {
            throw new OnlyTenThousandsException("Only ten thousands");
        };
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
