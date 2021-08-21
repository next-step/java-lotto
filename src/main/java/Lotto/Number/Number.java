package Lotto.Number;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int lottoNumber) {
        isValid(lottoNumber);
        this.number = lottoNumber;
    }

    private void isValid(int number) {
        if (Limit.MAX.isUnder(number) || Limit.MIN.isAbove(number)) {
            throw new IllegalArgumentException("로또 숫자는 1 이상, 45 이하의 정수입니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
