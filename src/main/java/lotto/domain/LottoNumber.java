package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    public static final String RANGE_EXCEPTION_MESSAGE = "복권의 숫자 범위가 유효하지 않습니다.";

    private final int number;

    private LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        return new LottoNumber(number);
    }

    private void validateNumberRange(final int number) {
        if (number < LOTTO_START_NUM || number > LOTTO_END_NUM) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.number > lottoNumber.number) {
            return 1;
        }
        if (this.number == lottoNumber.number) {
            return 0;
        }

        return -1;
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
