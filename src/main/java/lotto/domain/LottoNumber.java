package lotto.domain;

import java.util.Objects;

import static lotto.domain.Constant.LOTTO_NUM_MAX;
import static lotto.domain.Constant.LOTTO_NUM_MIN;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int intValue() {
        return lottoNumber;
    }

    public boolean isMatch(int bonusNumber) {
        return lottoNumber == bonusNumber;
    }

    private void validateRange(int lottoNumber) {
        if (lottoNumber < LOTTO_NUM_MIN || LOTTO_NUM_MAX < lottoNumber) {
            throw new LottoNumberRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
