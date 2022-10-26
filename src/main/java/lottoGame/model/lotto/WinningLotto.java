package lottoGame.model.lotto;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumber, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers + "";
    }

}
