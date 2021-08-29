package lotto.game;

import java.util.Objects;

public class Payments {

    public static final int ZERO = 0;
    private final int amount;

    public Payments(int amount) {
        isValid(amount);
        this.amount = amount;
    }

    private void isValid(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException("구매 금액은 양수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments1 = (Payments) o;
        return amount == payments1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int value() {
        return this.amount;
    }
}
