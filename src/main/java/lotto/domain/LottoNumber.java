package lotto.domain;

import java.util.Objects;
import lotto.domain.utils.Parser;

public class LottoNumber {

    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private static final String NOT_A_NUMBER_EXCEPTION_MESSAGE = "로또 번호의 입력은 숫자만 허용합니다.";
    private static final String OUT_OF_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = String.format(
            "로또 번호는 %d부터 %d 까지 입니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER);

    private final int value;

    public LottoNumber(String value) {
        int number = Parser.parseInt(value);
        validateLottoNumberRange(number);

        this.value = number;
    }

    private void validateLottoNumberRange(final int value) {
        if (isNotLottoNumberRange(value)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotLottoNumberRange(int value) {
        return value < LOTTO_START_NUMBER || value > LOTTO_END_NUMBER;
    }

    public int getValue() {
        return value;
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
