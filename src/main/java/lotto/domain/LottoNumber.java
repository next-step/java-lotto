package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateInputValue(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateInputValue(int value) {
        if (value < LOTTO_MIN_NUMBER || value > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("유효한 로또 숫자가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
