package lotto.domain;

import java.util.Objects;
import lotto.exception.WrongLottoNumberException;

public class LottoNumber {

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new WrongLottoNumberException(String.format("'%d'는 유효한 번호가 아닙니다.", lottoNumber));
        }

    }

    public int value() {
        return lottoNumber;
    }


    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber number = (LottoNumber) o;
        return lottoNumber == number.lottoNumber;
    }


}
