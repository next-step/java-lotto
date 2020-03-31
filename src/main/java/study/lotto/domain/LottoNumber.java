package study.lotto.domain;

import study.lotto.domain.exception.IllegalNumberRangeArgumentException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String NUMBER_RANGE_ERROR_MESSAGE =
            "숫자는 %d이상 %d이하여야 합니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalNumberRangeArgumentException(
                    String.format(NUMBER_RANGE_ERROR_MESSAGE, MIN_NUMBER,
                            MAX_NUMBER));
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public LottoNumber clone() {
        return new LottoNumber(this.number);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override public int hashCode() {
        return Objects.hash(number);
    }

    @Override public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
