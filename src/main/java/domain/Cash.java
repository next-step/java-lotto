package domain;

import java.util.Objects;

public class Cash {
    private final int cashAmount;

    public Cash(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public int capableLottoCount(int lottoPrice) {
        return cashAmount / lottoPrice;
    }

    public boolean isLessThan(int comparedNumber) {
        return cashAmount < comparedNumber;
    }

    public boolean isMultipleOf(int price) {
        return cashAmount % price == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return cashAmount == cash.cashAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashAmount);
    }

    @Override
    public String toString() {
        return String.valueOf(cashAmount);
    }
}
