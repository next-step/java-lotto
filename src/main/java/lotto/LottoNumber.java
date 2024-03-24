package lotto;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int compareTo(LottoNumber other) {
        return other.minus(this.number);
    }

    private int minus(int number) {
        return number - this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
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
