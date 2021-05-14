package lotto.domain;

import java.util.Objects;

import static lotto.exception.Message.*;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int totalPayment;
    private final int manualCount;
    private final int autoCount;

    private Money(int totalPayment, int manualCount) {
        validate(totalPayment, manualCount);
        this.totalPayment = totalPayment;
        this.manualCount = manualCount;
        this.autoCount = totalLottoCount() - manualCount;
    }

    public static Money of(int totalPayment, int manualCount) {
        return new Money(totalPayment, manualCount);
    }

    private void validate(int totalPayment, int manualCount) {
        if (totalPayment < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_MONEY_MESSAGE);
        }
        if (totalPayment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_MESSAGE);
        }
        if (totalPayment < manualCount * LOTTO_PRICE) {
            throw new IllegalArgumentException(MANUAL_MAXIMUM_MESSAGE);
        }
    }

    public int purchaseAuto() {
        return autoCount;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    private int totalLottoCount() {
        return totalPayment / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getTotalPayment() == money.getTotalPayment() &&
                manualCount == money.manualCount &&
                autoCount == money.autoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalPayment(), manualCount, autoCount);
    }
}
