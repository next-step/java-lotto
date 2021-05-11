package lotto.domain;

import java.util.Objects;

import static lotto.exception.Message.*;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int payment;
    private final int manualCounts;
    private final int autoPayment;

    private Money(int money, int manualCounts) {
        validate(money, manualCounts);
        this.payment = money;
        this.manualCounts = manualCounts;
        this.autoPayment = money - manualCounts * LOTTO_PRICE;
    }

    public static Money of(int payment, int manualCounts) {
        return new Money(payment, manualCounts);
    }

    private void validate(int payment, int manualCounts) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_MONEY_MESSAGE);
        }
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_MESSAGE);
        }
        if (payment < manualCounts * LOTTO_PRICE) {
            throw new IllegalArgumentException(MANUAL_MAXIMUM_MESSAGE);
        }
    }

    public int purchaseAuto() {
        return autoPayment / LOTTO_PRICE;
    }

    public int getPayment() {
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return payment == money1.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment);
    }
}
