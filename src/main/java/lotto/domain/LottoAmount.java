package lotto.domain;

import java.util.Objects;

public class LottoAmount {

    public static final int LOTTO_AMOUNT = 1_000;

    private final int amount;

    private LottoAmount(int amount) {
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    public static LottoAmount of(int amount) {
        return new LottoAmount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoAmount that = (LottoAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int count() {
        return amount / LOTTO_AMOUNT;
    }

}
