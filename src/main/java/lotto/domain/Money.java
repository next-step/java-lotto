package lotto.domain;

import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(0);
    
    private final long value;

    public Money(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0.");
        }
        this.value = value;
    }

    public int lottoCount(Money price) {
        return (int) (value / price.value);
    }

    public Money plus(Money other) {
        return new Money(value + other.value);
    }

    public long value() {
        return value;
    }

    public boolean isZero() {
        return equals(ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
