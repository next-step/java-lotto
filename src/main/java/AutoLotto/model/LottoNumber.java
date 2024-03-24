package autoLotto.model;

import static autoLotto.model.LottoConstants.*;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumber(int lotto) {
        if (!isValidLottoNumber(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public boolean isSameNumber(int number) {
        return lottoNumber == number;
    }

    public String getLottoNumberAsString() {
        return String.valueOf(lottoNumber);
    }
}
