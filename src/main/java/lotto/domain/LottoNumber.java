package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int value) {
        numberRangeCheck(value);
        this.number = value;
    }

    public LottoNumber(String value) {
        int valueNumber = Parser.parseNumberFormat(value);
        numberRangeCheck(valueNumber);
        this.number = valueNumber;
    }

    private void numberRangeCheck(int value) {
        if (value < Lotto.START_NUMBER || value > Lotto.END_NUMBER) {
            throw new IllegalArgumentException("숫자 범위를 벗어납니다. 숫자범위 : 1~45");
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
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
        return String.valueOf(number);
    }
}
