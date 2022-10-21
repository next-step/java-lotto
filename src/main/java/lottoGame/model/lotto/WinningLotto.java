package lottoGame.model.lotto;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;
    private final int bonus;

    public WinningLotto(List<LottoNumber> lottoNumber, int bonus) {
        this.lottoNumbers = lottoNumber;
        this.bonus = bonus;
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers + "";
    }

}
