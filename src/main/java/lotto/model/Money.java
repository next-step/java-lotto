package lotto.model;

public final class Money {
    public static final Money MONEY_BASE = new Money(1000);

    private static final int ZERO = 0;
    private static final int BASE = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액은 음수일 수 없습니다. money: " + money);
        }
        if (isBaseMoneyUnit(money)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액은 천원 단위여야 합니다. money: " + money);
        }
    }

    private boolean isBaseMoneyUnit(int money) {
        return money % BASE != ZERO;
    }

    private boolean isNegative(int money) {
        return money < ZERO;
    }

    public int getUnitCount() {
        return this.money / MONEY_BASE.money;
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
