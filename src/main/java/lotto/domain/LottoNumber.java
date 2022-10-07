package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d 보다 같거나 큰 값이어야 합니다.", MIN_VALUE));
        }
        if (value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d 보다 같거나 작은 값이어야 합니다.", MAX_VALUE));
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
