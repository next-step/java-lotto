package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String ERR_NUMBER_RANGE = "Lotto numbers should by between 1 and 45";
    public static final int UPPER_BOUND = 45;
    public static final int LOWER_BOUND = 1;
    private final int number;

    public LottoNumber(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(ERR_NUMBER_RANGE);
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        LottoNumber other = (LottoNumber) obj;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
