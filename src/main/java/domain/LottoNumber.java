package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    private int number;

    public LottoNumber(int number) {
        this.number = number;
        validate();
    }


    private void validate() {
        if (number > MAX_LOTTO_NUM || number < MIN_LOTTO_NUM) {
            throw new IllegalArgumentException(MIN_LOTTO_NUM + " ~ " + MAX_LOTTO_NUM + "사이의 값만 들어올 수 있습니다.");
        }
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
