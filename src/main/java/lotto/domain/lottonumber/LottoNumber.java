package lotto.domain.lottonumber;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    private static final String LOTTONUMBER_BOUND_EXCEPTION = "로또 번호는 1부터 45까지입니다.";

    public LottoNumber(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTONUMBER_BOUND_EXCEPTION);
        }
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
