package lotto.domains;

import java.util.Objects;
import lotto.exceptions.LottoNumberFormatException;

public class LottoNumber {
    protected static final int START_NUMBER = 1;
    protected static final int END_NUMBER = 45;

    private final int number;

    public LottoNumber(String string) {
        try {
            int number = Integer.parseInt(string);
            validateNumber(number);
            this.number = number;
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException(string);
        }
    }

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < START_NUMBER || END_NUMBER < number) {
            throw new IllegalArgumentException("로또 숫자(1 ~ 45)가 아닙니다. 입력값: " + number);
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
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
