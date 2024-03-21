package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

import java.util.Objects;

import static lotto.domain.LottoInformation.*;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) throws IllegalLottoNumberException {
        if (notInRange(number)) {
            throw new IllegalLottoNumberException(number);
        }
    }

    private boolean notInRange(int number) {
        return number < NUMBER_RANGE_FROM || number > NUMBER_RANGE_TO;
    }

    public int get() {
        return this.number;
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
