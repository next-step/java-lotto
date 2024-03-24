package lotto.domain.lotto;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

import static lotto.Validator.isInRange;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberRange(int lottoNumber) {
        if (!isInRange(lottoNumber, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
    }

    public static LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.lottoNumber;
    }

    public int lottoNumber() {
        return lottoNumber;
    }
}
