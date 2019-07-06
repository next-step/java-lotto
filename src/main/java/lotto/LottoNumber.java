package lotto;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }
}
