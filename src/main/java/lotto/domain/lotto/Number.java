package lotto.domain.lotto;

import java.util.Objects;
import lotto.domain.generator.LottoGenerator;

public class Number {

    private static final String EXCEPTION_NOT_IN_RANGE = "숫자가 범위 내에 있지 않습니다.";

    private final int number;

    public Number(final int number) {
        validateRange(number);
        this.number = number;
    }

    public int value() {
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
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateRange(final int number) {
        if (number < LottoGenerator.START_NUMBER || number > LottoGenerator.END_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_NOT_IN_RANGE);
        }
    }
}
