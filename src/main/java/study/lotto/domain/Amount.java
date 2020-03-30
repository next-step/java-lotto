package study.lotto.domain;

import study.lotto.domain.exception.IllegalAmountArgumentException;

import java.util.Objects;

public class Amount {
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "최소 금액은 %d원 입니다.";
    private static final int AMOUNT_MIN = 0;
    private int amount;

    public Amount(int amount) {
        if (amount < AMOUNT_MIN) {
            throw new IllegalAmountArgumentException(MIN_AMOUNT_ERROR_MESSAGE);
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override public int hashCode() {
        return Objects.hash(amount);
    }
}
