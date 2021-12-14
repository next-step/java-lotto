package lotto.domain;

import java.util.Objects;

public class Amount {
    public static int PIECE_OF_LOTTO = 1000;
    private double value;

    public Amount(double value) {
        if(value < 0 || !(value % PIECE_OF_LOTTO == 0)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int lottoPieceCount() {
        return (int)(this.value / PIECE_OF_LOTTO);
    }

    public Rate dividedAmount(Amount divisor) {
        //return new Rate(Math.floor((this.value / divisor.value) * 100) / 100.0);
        return new Rate(0).rate(this.value, divisor.value);
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
