package lotto.domain;

import lotto.common.ErrorMessage;

public class LottoNumber implements Comparable {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    
    private int lottoNumber;
    
    public LottoNumber(int lottoNumber) {
        if (!isInNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
        }
        this.lottoNumber = lottoNumber;
    }
    
    private static boolean isInNumberRange(int lottoNumber) {
        return lottoNumber >= MIN_NUMBER && lottoNumber <= MAX_NUMBER;
    }
    
    public boolean isBig(LottoNumber inputLottoNumber) {
        return lottoNumber > inputLottoNumber.lottoNumber;
    }
    
    public LottoNumber getCopied() {
        return new LottoNumber(lottoNumber);
    }
    
    @Override
    public int compareTo(Object o) {
        LottoNumber inputNumber = (LottoNumber) o;
        return lottoNumber - inputNumber.lottoNumber;
    }
    
    @Override
    public String toString() {
        return lottoNumber + "";
    }
}
