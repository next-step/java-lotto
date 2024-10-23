package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_LOWER_LIMIT;
import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_UPPER_LIMIT;

public class LottoNumber {
    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    private void validateLottoNumberRange(Integer lottoNumber) {
        if (lottoNumber == null || lottoNumber < LOTTO_NUMBER_LOWER_LIMIT || lottoNumber > LOTTO_NUMBER_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format("로또번호는 %d~%d 사이의 숫자만 가능합니다", LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT));
        }
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
        return Objects.hashCode(lottoNumber);
    }
}
