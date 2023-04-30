package lotto.domain;

import lotto.exception.LottoNumberOutOfRangeException;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        validate();
    }

    private void validate() {
        if(1<= lottoNumber && lottoNumber<=45) {
            return;
        }
        throw new LottoNumberOutOfRangeException();
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
