package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private final int number;

    public LottoNumber(int number) {
        assertValidRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void assertValidRange(int number) {
        String errorMessage = String.format("[로또] 숫자의 범위는 %d 부터 %d까지 입니다.", MIN_NUMBER, MAX_NUMBER);

        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException(errorMessage);
        }
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
