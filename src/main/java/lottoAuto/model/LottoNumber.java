package lottoAuto.model;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        invalidateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void invalidateLottoNumber(int lottoNumber) {
        if (lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 45이하여야 합니다.");
        }
    }

    public boolean hasNumber(int number){
        return lottoNumber == number;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
