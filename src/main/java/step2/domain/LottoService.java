package step2.domain;

import step2.domain.model.Lotto;
import step2.domain.model.Lottos;
import step2.domain.strategy.lotto.Strategy;

import java.util.List;


public class LottoService {
    private Lottos lottos;
    private Lotto winnerLotto;

    public LottoService(Strategy strategy, int lottoCount, String lastWinningNumbers) {
        this.lottos = new Lottos(strategy, lottoCount);
        this.winnerLotto = Lotto.createWinnerLotto(strategy, lastWinningNumbers);
    }

    public static LottoService createLottoService(Strategy strategy, int lottoCount, String lastWinningNumbers) {
        return new LottoService(strategy, lottoCount, lastWinningNumbers);
    }

    public void calculatorLottoWinningCount() {
        List<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            lotto.calculatorLottoWinningCount(winnerLotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
