package study.lotto.domain;

import study.lotto.exception.LottoException;
import study.lotto.util.Validation;

import java.util.Objects;

import static study.lotto.service.LottoFactory.MAX_NUMBER_BOUND;
import static study.lotto.service.LottoFactory.MIN_NUMBER_BOUND;
import static study.lotto.util.Constants.GUIDE_ERR_NOT_USE_VALUE;

/**
 * 로또 숫자 번호에 대한 wrapper class
 */
public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    LottoNumber(final String bonusNumber) {
        this(Validation.parseInt(bonusNumber));
    }

    LottoNumber(final int number) {
        if(isInvalidNumber(number)) {
            throw new LottoException(GUIDE_ERR_NOT_USE_VALUE);
        }
        this.number = number;
    }

    public static LottoNumber of(final String number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    private boolean isInvalidNumber(final int number) {
        return MIN_NUMBER_BOUND > number || MAX_NUMBER_BOUND < number;
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
