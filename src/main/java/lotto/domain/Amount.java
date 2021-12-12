package lotto.domain;

import java.util.Objects;

public class Amount {
    public static int PIECE_OF_LOTTO = 1000;
    private int value;

    public Amount(int value) {
        if(value <= 0 || !(value % PIECE_OF_LOTTO == 0)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int lottoPieceCount() {
        return this.value / PIECE_OF_LOTTO;
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
