package lotto;

import java.util.Objects;

import static java.lang.String.format;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String INVALID_RANGE_ERROR_MESSAGE = format("%s ~ %s 의 값만 사용가능합니다.", MIN_NUMBER, MAX_NUMBER);

    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
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
