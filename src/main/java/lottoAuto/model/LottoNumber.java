package lottoAuto.model;

import static lottoAuto.model.Numbers.MAX_LOTTO_NUMBER;

public class LottoNumber {
    private static final int ZERO_LOTTO_NUMBER = 0;
    private static final String OVER_LOTTO_NUMBER_MESSAGE = "로또 번호는 45이하여야 합니다.";
    private static final String ZERO_LOTTO_NUMBER_MESSAGE = "로또 번호는 0이 아니어야 합니다.";
    private static final String BELOW_LOTTO_NUMBER_MESSAGE = "로또 번호는 양수여야 합니다.";

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OVER_LOTTO_NUMBER_MESSAGE);
        }
        if (lottoNumber == ZERO_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ZERO_LOTTO_NUMBER_MESSAGE);
        }
        if (lottoNumber < ZERO_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BELOW_LOTTO_NUMBER_MESSAGE);
        }
    }

    public boolean isNumber(int number) {
        return lottoNumber == number;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
