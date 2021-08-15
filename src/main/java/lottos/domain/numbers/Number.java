package lottos.domain.numbers;

import lottos.domain.exceptions.LottoNumberRangeIncorrectException;

import java.util.Objects;


public class Number {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final Integer number;

    private Number(final Integer number) {
        checkNumberRange(number);
        this.number = number;
    }

    public static Number valueOf(final Integer number) {
        return new Number(number);
    }

    private void checkNumberRange(final Integer number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new LottoNumberRangeIncorrectException();
        }
    }

    public Integer value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
