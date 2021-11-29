package lotto.domain;

import java.util.Objects;

import static lotto.utils.Constants.*;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < NUMBER_ZERO || lottoNumber > NUMBER_FORTY_FIVE) {
            throw new IllegalArgumentException(MSG_LOTTO_NUMBER_ONE_TO_FORTY_FIVE);
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
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
