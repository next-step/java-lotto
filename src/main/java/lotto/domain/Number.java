package lotto.domain;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        verifyLottoNumber(number);
        this.number = number;
    }

    private void verifyLottoNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("로또 번호로 적합하지 않습니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
