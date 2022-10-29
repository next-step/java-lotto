package lotto.domain;

import java.util.Objects;

public class PaidAmount {

    public static final int LOTTO_PRICE = 1000;
    private final int paidAmount;

    public PaidAmount(int paidAmount) {
        verifyAmount(paidAmount);
        this.paidAmount = paidAmount;
    }

    private void verifyAmount(int paidAmount) {
        if (paidAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(paidAmount + "원으로는 로또를 구매할 수 없습니다.");
        }
    }

    public int getPurchasableTicketNo() {
        return paidAmount / LOTTO_PRICE;
    }

    public int getPaidAmount() {
        return this.paidAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidAmount that = (PaidAmount) o;
        return paidAmount == that.paidAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paidAmount);
    }
}
