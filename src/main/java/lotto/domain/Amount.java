package lotto.domain;

import java.util.Objects;

public class Amount {
    private static final String INVALID_AMOUNT = "로또 금액보다 높은 금액을 입력해야 합니다.";
    private static final int LOTTO_AMOUNT = 1000;

    private int value;
    public Amount(final int amount) {
        validationCheck(amount);
        
        this.value = amount;
    }

    private void validationCheck(final int amount) {
        if (isSmallThan(amount)) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }

    public static Amount ofLottoAmount() {
        return new Amount(LOTTO_AMOUNT);
    }

    private boolean isSmallThan(final int amount) {
        return amount < LOTTO_AMOUNT;
    }

    public int divide(final Amount amount) {
        return value / amount.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
