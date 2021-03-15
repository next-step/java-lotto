package step2.domain;

import java.util.Objects;

public class LottoNumber {

    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("올바르지 않는 로또 번호입니다.");
        }
        this.number = number;
    }

    public int toNumber() {
        return this.number;
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
