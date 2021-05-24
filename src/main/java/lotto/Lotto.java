package lotto;

import java.util.List;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto() {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumberUtils();
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(LottoRandomNumber lottoRandomNumber) {
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public int compareWinLottoNumber(List<Integer> winLottoNumber) {
        return lottoNumber.countCollectNumber(winLottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
