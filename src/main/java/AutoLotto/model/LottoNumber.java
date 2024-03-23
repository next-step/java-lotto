package autoLotto.model;

import static autoLotto.model.LottoConstants.*;

public class LottoNumber {
    private Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumber(Integer lotto) {
        if (!isValidLottoNumber(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
