package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String ERR_NUMBER_RANGE = "Lotto numbers should by between 1 and 45";
    private final int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERR_NUMBER_RANGE);
        }
        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
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
