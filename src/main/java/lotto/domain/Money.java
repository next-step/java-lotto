package lotto.domain;

import java.util.Objects;

import static lotto.exception.Message.*;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int totalPayment;
    private final int manualCounts;
    private final int autoPayment;

    private Money(int totalPayment, int manualCounts) {
        validate(totalPayment, manualCounts);
        this.totalPayment = totalPayment;
        this.manualCounts = manualCounts;
        this.autoPayment = totalPayment - manualCounts * LOTTO_PRICE;
    }

    public static Money of(int totalPayment, int manualCounts) {
        return new Money(totalPayment, manualCounts);
    }

    private void validate(int totalPayment, int manualCounts) {
        if (totalPayment < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_MONEY_MESSAGE);
        }
        if (totalPayment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_MESSAGE);
        }
        if (totalPayment < manualCounts * LOTTO_PRICE) {
            throw new IllegalArgumentException(MANUAL_MAXIMUM_MESSAGE);
        }
    }

    public int purchaseAuto() {
        return autoPayment / LOTTO_PRICE;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getTotalPayment() == money.getTotalPayment() &&
                manualCounts == money.manualCounts &&
                autoPayment == money.autoPayment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalPayment(), manualCounts, autoPayment);
    }
}
