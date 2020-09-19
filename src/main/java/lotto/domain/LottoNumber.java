package lotto.domain;

public class LottoNumber {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoRange(int lottoNumber) {
        if(lottoNumber < LOTTO_MIN || lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException("로또의 범위를 벗어났습니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

}
