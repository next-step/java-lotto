package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final String INVALID_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1 이상 45 이하입니다.";

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        validateLottoNumber();
    }

    public int value() {
        return lottoNumber;
    }

    private void validateLottoNumber() {
        if (lottoNumberOutRange()) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean lottoNumberOutRange() {
        return lottoNumber < LOTTO_MINIMUM_BOUND || lottoNumber > LOTTO_MAXIMUM_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lotto = (LottoNumber) o;
        return lottoNumber == lotto.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
