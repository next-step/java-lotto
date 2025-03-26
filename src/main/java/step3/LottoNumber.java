package step3;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new RuntimeException("로또의 숫자는 1 - 45 사이만 가능합니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
