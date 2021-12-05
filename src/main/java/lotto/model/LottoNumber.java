package lotto.model;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private static final Random RANDOM = new Random();
    private final int number;

    public LottoNumber() {
        this(RANDOM.nextInt(45) + 1);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getLottoNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
