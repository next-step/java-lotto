package study.lotto.domain;

import study.lotto.exception.LottoException;
import study.lotto.generator.LottoNumberGenerator;

import java.util.Objects;

/**
 * 로또 숫자 번호에 대한 wrapper class
 */
public class LottoNumber implements Comparable<LottoNumber> {

    public static final String GUIDE_NOT_USE_VALUE = "로또 번호로 사용할 수 없는 값 입니다.";
    private final int number;

    public LottoNumber(final int number) {
        if(isInvalidNumber(number)) {
            throw new LottoException(GUIDE_NOT_USE_VALUE);
        }
        this.number = number;
    }

    private boolean isInvalidNumber(final int number) {
        return LottoNumberGenerator.MIN_NUMBER_BOUND > number || LottoNumberGenerator.MAX_NUMBER_BOUND < number;
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
        return this.number - o.number;
    }
}
