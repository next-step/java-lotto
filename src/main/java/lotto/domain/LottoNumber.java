package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 45;
    private static final String ERROR_MESSAGE = "로또 숫자는 1~45 사이이어야 합니다.";
    private final int value;

    public LottoNumber(final int value) {
        validateRange(value);
        this.value = value;
    }

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    private void validateRange(final int value) {
        if (value < MIN_RANGE_NUMBER || value > MAX_RANGE_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }
}
