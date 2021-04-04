package step02;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) throws Exception {
        Validation.overMaxNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
