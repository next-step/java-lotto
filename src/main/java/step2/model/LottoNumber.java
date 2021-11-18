package step2.model;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN || lottoNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호가 아닙니다");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(LottoNumber.class)) {
            return false;
        }
        LottoNumber other = (LottoNumber) o;
        return this.lottoNumber == other.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
