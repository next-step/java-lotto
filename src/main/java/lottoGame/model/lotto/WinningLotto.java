package lottoGame.model.lotto;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;

    public WinningLotto(List<LottoNumber> lottoNumber) {
        this.lottoNumbers = lottoNumber;
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers + "";
    }

}
