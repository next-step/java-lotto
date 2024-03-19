package lotto.data;

import java.util.Objects;

import static lotto.util.ConstUtils.*;

public class LottoNumberVO {
    private final int lottoNumber;

    public LottoNumberVO(int lottoNumber) {
        validateLottoNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoNumberVO that = (LottoNumberVO) object;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_RANGE || lottoNumber > MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다. 1~45 숫자중 입력 해 주세요.");
        }
    }
}
