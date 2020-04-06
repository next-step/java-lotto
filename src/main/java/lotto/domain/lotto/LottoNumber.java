package lotto.domain.lotto;

import java.util.Objects;

import static lotto.domain.Constant.LOTTO_NUM_MAX;
import static lotto.domain.Constant.LOTTO_NUM_MIN;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String lottoNumber) {
        int parseLottoNumber = parseLottoNumber(lottoNumber);
        validateRange(parseLottoNumber);
        this.lottoNumber = parseLottoNumber;
    }

    public int intValue() {
        return lottoNumber;
    }

    public boolean isEqualBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isMatch(lottoNumber);
    }

    void validateRange(int lottoNumber) {
        if (isValidRange(lottoNumber)) {
            throw new LottoNumberRangeException();
        }
    }

    private boolean isValidRange(int lottoNumber) {
        return lottoNumber < LOTTO_NUM_MIN || LOTTO_NUM_MAX < lottoNumber;
    }

    private int parseLottoNumber(String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber.trim());
        } catch (NumberFormatException e) {
            throw new LottoNumberInvalidException();
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
