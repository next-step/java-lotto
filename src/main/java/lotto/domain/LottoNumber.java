package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        checkNumber(number);
        this.number = number;
    }

    private void checkNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("유효한 숫자 범위는 1~45 입니다.");
        }
    }

    public int intValue() {
        return number;
    }

    public int compareTo(LottoNumber target) {
        return Integer.compare(number,target.number);
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
