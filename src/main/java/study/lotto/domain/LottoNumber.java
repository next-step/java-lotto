package study.lotto.domain;

import study.lotto.exception.LottoException;
import study.lotto.generator.LottoGenerator;

import java.util.Objects;

/**
 * 로또 숫자 번호에 대한 wrapper class
 */
public class LottoNumber {

    private final int number;

    public LottoNumber(final int number) {
        if(isInvalidNumber(number)) {
            throw new LottoException();
        }
        this.number = number;
    }

    private boolean isInvalidNumber(final int number) {
        return LottoGenerator.MIN_NUMBER_BOUND > number || LottoGenerator.MAX_NUMBER_BOUND < number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
