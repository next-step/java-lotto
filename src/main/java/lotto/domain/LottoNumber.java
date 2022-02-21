package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int START_NUMBER = 1;
    private final int LAST_NUMBER = 45;
    private final String NUMBER_INVALID = "유효한 숫자 범위가 아닙니다.";

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < START_NUMBER || number > LAST_NUMBER) {
            throw new IllegalArgumentException(NUMBER_INVALID);
        }
    }

    public int getLottoNumber() {
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
    public int hashCode() {
        return Objects.hash(START_NUMBER, LAST_NUMBER, NUMBER_INVALID, number);
    }
}
