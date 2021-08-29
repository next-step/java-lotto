package lotto.game;

import java.util.Objects;

public class Payments {

    public static final int ZERO = 0;
    private final int payments;

    public Payments(int payments) {
        isValid(payments);
        this.payments = payments;
    }

    private void isValid(int payments) {
        if (payments <= ZERO) {
            throw new IllegalArgumentException("구매 금액은 양수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments1 = (Payments) o;
        return payments == payments1.payments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payments);
    }

    public int value() {
        return this.payments;
    }
}
