package step3.domain;

import step3.exception.LottoNumberRangeException;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        valid(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void valid(int lottoNumber) {
        if(!findRange(lottoNumber)){
            throw new LottoNumberRangeException();
        }
    }

    private boolean findRange(int lottoNumber) {
        return lottoNumber <= MAX_LOTTO_NUMBER && lottoNumber >= MIN_LOTTO_NUMBER;
    }


}
