package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final LottoNumberPattern LOTTO_NUMBER_PATTERN = new LottoNumberPattern();
    private final int number;

    public LottoNumber(int number) {
        this(String.valueOf(number));
    }

    public LottoNumber(String number) {
        if (!LOTTO_NUMBER_PATTERN.match(number)) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE, number);
        }
        this.number = Integer.parseInt(number);
    }

    private int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
