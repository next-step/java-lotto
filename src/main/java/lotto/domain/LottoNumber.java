package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    static final int UPPER = 45;
    static final int LOWER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (LOWER > number ||  UPPER < number) {
            throw new IllegalArgumentException("로또 숫자 범위는 1 ~ 45 입니다.z");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
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

}
