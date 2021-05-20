package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final String LOTTO_NUMBER_BOUNDARY_ERROR_MESSAGE = "로또 번호는 1 ~ 45 사이의 수여야 합니다.";

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            LottoNumber other = (LottoNumber) obj;
            return this.lottoNumber.equals(other.lottoNumber);
        }
        return false;
    }

    private void validateLottoNumber(Integer lottoNumber) {
        if (lottoNumber < MINIMUM_NUMBER || lottoNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_BOUNDARY_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.lottoNumber.compareTo(other.lottoNumber);
    }
}
