package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    protected static final String LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION = "로또의 숫자는 1에서 45 사이의 숫자만 가능합니다.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int number) {
        if (outOfRange(number)) {
            throw new IllegalStateException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
        return lottoNumber;
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
}
