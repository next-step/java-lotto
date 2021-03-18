package study.lotto.domain;

import study.lotto.exception.LottoException;
import study.lotto.util.Validation;

import java.util.Objects;

import static study.lotto.generator.LottoNumberGenerator.MAX_NUMBER_BOUND;
import static study.lotto.generator.LottoNumberGenerator.MIN_NUMBER_BOUND;

/**
 * 로또 숫자 번호에 대한 wrapper class
 */
public class LottoNumber implements Comparable<LottoNumber> {

    public static final String GUIDE_CANNOT_PARSE_STRING_TO_INTEGER = "숫자로 캐스팅 할 수 없는 값 입니다.";
    public static final String GUIDE_NOT_USE_VALUE = "로또 번호로 사용할 수 없는 값 입니다.";
    private final int number;

    public LottoNumber(final String bonusNumber) {
        this(Validation.parseInt(bonusNumber));
    }

    public LottoNumber(final int number) {
        if(isInvalidNumber(number)) {
            throw new LottoException(GUIDE_NOT_USE_VALUE);
        }
        this.number = number;
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
