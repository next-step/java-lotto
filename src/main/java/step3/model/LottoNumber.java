package step3.model;

import static java.lang.String.format;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String RANGE_ERROR_MESSAGE = format("로또 번호는 %d부터 %d 사이여야 합니다.", MIN, MAX);

    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber other = (LottoNumber) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
