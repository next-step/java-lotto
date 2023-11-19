package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int ONE = 1;
    private static final int FORTY_FIVE = 1;
    private int number;
    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private static void validateNumber(int number) {
        if (number < ONE || number > FORTY_FIVE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자입니다.");
        }
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
