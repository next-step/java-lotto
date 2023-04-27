package step2.domain.model.Lotto;

import step2.domain.strategy.lotto.Strategy;

import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers createLottoNumbers(Strategy strategy) {
        return new LottoNumbers(strategy.createLottoNumber());
    }

    public static LottoNumbers createWinnerLottoNumbers(Strategy strategy, String lastWinningNumbers) {
        return new LottoNumbers(strategy.createWinningLotto(lastWinningNumbers));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
