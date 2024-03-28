package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        checkBoundaryNumbers(number);
        this.number = number;
    }

    private static void checkBoundaryNumbers(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 입력할 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
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
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
