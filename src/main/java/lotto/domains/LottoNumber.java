package lotto.domains;

import java.util.Objects;

public class LottoNumber {
    protected static final int START_NUMBER = 1;
    protected static final int END_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < START_NUMBER || END_NUMBER < number) {
            throw new IllegalArgumentException("로또 숫자(1 ~ 45)가 아닙니다. 입력값: " + number);
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
