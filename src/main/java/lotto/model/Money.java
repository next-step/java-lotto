package lotto.model;

public final class Money {
    private static final long ZERO = 0;

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다. money: " + money);
        }
    }

    private boolean isNegative(long money) {
        return money < ZERO;
    }

    public boolean isDivided(Money unit) {
        return this.money % unit.money == 0;
    }

    public double divideBy(Money denominator) {
        if (denominator.money == ZERO) {
            return ZERO;
        }
        return this.money / (double) denominator.money;
    }

    public long calculateUnitCount(Money unit) {
        return this.money / unit.money;
    }

    public Money add(Money other) {
        if (other.money == ZERO) {
            return this;
        }
        return new Money(this.money + other.money);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            return this.money == ((Money) obj).money;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(money).hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
