package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        if (MINIMUM_NUMBER > value || MAXIMUM_NUMBER < value) {
            throw new IllegalArgumentException("로또 번호가 올바르지 않습니다.");
        }

        this.value = value;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
