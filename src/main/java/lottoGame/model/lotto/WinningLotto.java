package lottoGame.model.lotto;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningLotto(List<LottoNumber> lottoNumber, LottoNumber bonus) {
        this.lottoNumbers = lottoNumber;
        this.bonus = bonus;
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers + "";
    }

}
