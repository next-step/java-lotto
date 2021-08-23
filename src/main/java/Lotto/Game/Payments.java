package Lotto.Game;

import java.util.Objects;

public class Payments {

    public static final int LOTTO_TICKET_RICE = 1000;
    public static final int REMAINDER = 0;
    public static final int ZERO = 0;
    private final int payments;

    public Payments(int payments) {
        isValid(payments);
        this.payments = payments;
    }

    private void isValid(int payments) {
        isMultipleOf1000(payments);
        isPositive(payments);
    }

    private void isPositive(int payments) {
        if (payments <= ZERO) {
            throw new IllegalArgumentException("구매 금액은 양수입니다.");
        }
    }

    private void isMultipleOf1000(int payments) {
        if (payments % LOTTO_TICKET_RICE != REMAINDER) {
            throw new IllegalArgumentException("구매 금액은 1000의 배수이어야 합니다.");
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

    public int getValue() {
        return this.payments;
    }
}
