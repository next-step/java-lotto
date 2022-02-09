package lotto.domain.lotto;

import java.util.Objects;
import lotto.domain.generator.LottoGenerator;

public class Number {

    private final int number;

    private static final String EXCEPTION_NUMBER_RANGE = "[ERROR] 숫자의 범위가 올바르지 않습니다.";

    public Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int value() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < LottoGenerator.START_NUMBER || LottoGenerator.END_NUMBER < number) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
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
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
