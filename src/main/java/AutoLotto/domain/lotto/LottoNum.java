package AutoLotto.domain.lotto;

public class LottoNum {

    private final int lottoNum;

    LottoNum(int lottoNum) {
        this.lottoNum = checkLottoNum(lottoNum);
    }

    public int getLottoNum() {
        return lottoNum;
    }

    private int checkLottoNum(int lottoNum) {
        if (lottoNum <= 45 && lottoNum > 0) {
            return lottoNum;
        }
        throw new RuntimeException();
    }
}
