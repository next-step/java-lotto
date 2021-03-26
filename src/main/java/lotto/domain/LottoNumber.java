package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber < LottoConstant.MIN_LOTTO_NUMBER || lottoNumber > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

}
