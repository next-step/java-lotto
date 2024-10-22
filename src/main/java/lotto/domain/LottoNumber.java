package lotto.domain;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        checkLottoNumber();
    }

    private void checkLottoNumber() {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public boolean compareNumber(int insertLottoNumber) {
        return lottoNumber == insertLottoNumber;
    }
}
