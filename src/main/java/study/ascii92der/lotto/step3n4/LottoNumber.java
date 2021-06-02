package study.ascii92der.lotto.step3n4;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;
    public static final String ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER = "out of range Lotto number";

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validRangeNumber();
    }

    private void validRangeNumber() {
        if (!(number >= LOTTO_NUMBER_MINIMUM && LOTTO_NUMBER_MAXIMUM >= number)) {
            throw new IllegalArgumentException(ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER);
        }
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
}