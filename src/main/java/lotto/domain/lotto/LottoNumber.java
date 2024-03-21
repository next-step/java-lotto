package lotto.domain.lotto;

import java.util.Objects;

import static lotto.Validator.isInRange;

public class LottoNumber {
    private static final String WRONG_LOTTO_NUMBER_MESSAGE = "(%d): 잘못된 번호입니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberRange(int lottoNumber) {
        if (!isInRange(lottoNumber, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(String.format(WRONG_LOTTO_NUMBER_MESSAGE, lottoNumber));
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

    public int lottoNumber() {
        return lottoNumber;
    }
}
