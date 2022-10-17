package lotto.domain.lottonumber;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    public static final int LOTTONUMBER_MINIMUM = 1;
    public static final int LOTTONUMBER_MAXIMUM = 45;
    private static final String LOTTONUMBER_BOUND_EXCEPTION
            = "로또 번호는 " + LOTTONUMBER_MINIMUM + "부터 " + LOTTONUMBER_MAXIMUM + "까지입니다.";

    public LottoNumber(final int number) {
        if (checkLottoNumberBound(number)) {
            throw new IllegalArgumentException(LOTTONUMBER_BOUND_EXCEPTION);
        }
        this.number = number;
    }

    private static boolean checkLottoNumberBound(int number) {
        return number < 1 || number > 45;
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
