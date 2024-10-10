package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이 숫자입니다");
        }
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumber))
            return false;
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }
}
