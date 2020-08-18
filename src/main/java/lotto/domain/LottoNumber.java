package lotto.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 {0}에서 {1}사이 숫자 입니다.";
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if(lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            String msg = MessageFormat.format(NUMBER_RANGE_ERROR_MESSAGE, LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            throw new IllegalArgumentException(msg);
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
