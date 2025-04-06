package Lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("The Lotto number must be between 1 and 45.");
        }
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber other = (LottoNumber) o;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
