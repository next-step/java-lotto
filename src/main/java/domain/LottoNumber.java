package domain;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private int number;

    public LottoNumber(int number) {
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
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
    public String toString() {
        return String.valueOf(this.number);
    }
}