package step3;

public class LottoNum {
    private final int lottoNum;

    public LottoNum(int lottoNum) {
        validateLottoNumber(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validateLottoNumber(int lottoNum) {
        if (lottoNum < 1 || lottoNum > 45) {
            throw new RuntimeException("로또의 숫자는 1 - 45 사이만 가능합니다.");
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
