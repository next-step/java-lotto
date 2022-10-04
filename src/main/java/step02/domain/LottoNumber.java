package step02.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;

    public static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        validateIsBetween(value);
        this.value = value;
    }

    private void validateIsBetween(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_VALUE + " ~ " + MAX_VALUE + "사이의 번호여야 합니다. | number " + value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
