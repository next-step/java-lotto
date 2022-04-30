package lotto.model;

public final class Money {
    private static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다. money: " + money);
        }
    }

    private boolean isNegative(int money) {
        return money < ZERO;
    }

    public boolean isDivided(Money unit) {
        return this.money % unit.money == 0;
    }

    public int getUnitCount(Money unit) {
        return this.money / unit.money;
    }

    public double getYield(long result) {
        return result / (double) this.money;
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
        return Integer.valueOf(money).hashCode();
    }

}
