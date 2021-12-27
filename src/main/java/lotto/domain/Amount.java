package lotto.domain;

import java.util.Objects;

public class Amount {
    public static int PIECE_OF_LOTTO = 1000;
    private long value;

    public Amount(long value) {
        if (value < 0 || !(value % PIECE_OF_LOTTO == 0)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public Amount multiflyCountAmount(Count count) {
        return new Amount(this.value * count.getValue());
    }

    public Amount sumedAmount(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public int lottoPieceCount() {
        return (int) (this.value / PIECE_OF_LOTTO);
    }

    public Rate dividedAmount(Amount divisor) {
        return new Rate(0).rate(this.value, divisor.value);
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amount)) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
