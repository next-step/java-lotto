package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber < LottoConstant.MIN_LOTTO_NUMBER || lottoNumber > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
