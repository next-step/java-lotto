package lotto.domain.number;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber {

    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    private static final String ERROR_OUT_OF_SCOPE_MESSAGE
            = "로또 숫자의 범위는 " + FIRST_NUMBER + "부터 " + LAST_NUMBER + " 사이입니다.";

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (isOutOfScope(number)) {
            throw new InvalidLottoNumberException(ERROR_OUT_OF_SCOPE_MESSAGE);
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    private boolean isOutOfScope(int number) {
        return number < FIRST_NUMBER || number > LAST_NUMBER;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
