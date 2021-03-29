package step2.domain.lotto;

import step2.exception.InvalidNumberInputException;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final LottoNumber[] cache;

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int ARRAY_LENGTH = MAXIMUM + 1;

    private final Integer lottoNumber;

    static {
        cache = new LottoNumber[ARRAY_LENGTH];
    }

    private LottoNumber(int lottoNumber) {
        this(Integer.valueOf(lottoNumber));
    }

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private static final boolean isCacheNull(Integer index) {
        return cache[index] == null;
    }

    private static final boolean isOutOfBounds(Integer lottoNumber) {
        return (isLessThanMinimum(lottoNumber) || isExceedMaximum(lottoNumber));
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        if (isOutOfBounds(lottoNumber)) {
            throw new InvalidNumberInputException();
        }
        if (isCacheNull(lottoNumber)) {
            cache[lottoNumber] = new LottoNumber(lottoNumber);
        }
        return cache[lottoNumber];
    }

    private static final boolean isLessThanMinimum(Integer lottoNumber) {
        return lottoNumber < MINIMUM;
    }

    private static final boolean isExceedMaximum(Integer lottoNumber) {
        return lottoNumber > MAXIMUM;
    }

    public final int getLottoNumber() {
        return lottoNumber.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
