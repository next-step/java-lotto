package lotto.domain.lottonumber;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    public static final int LOTTONUMBER_MINIMUM = 1;
    public static final int LOTTONUMBER_MAXIMUM = 45;
    private static final String LOTTONUMBER_BOUND_EXCEPTION
            = String.format("로또 번호는 %d부터 %d까지입니다.", LOTTONUMBER_MINIMUM, LOTTONUMBER_MAXIMUM);

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
