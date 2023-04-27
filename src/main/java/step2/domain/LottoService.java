package step2.domain;

import step2.domain.model.Lotto.Lotto;
import step2.domain.model.Lotto.Lottos;

import java.util.List;


public class LottoService {
    private Lottos lottos;
    private Lotto winnerLotto;

    public LottoService(int lottoCount, String lastWinningNumbers) {
        this.lottos = new Lottos(lottoCount);
        this.winnerLotto = Lotto.createWinnerLotto(lastWinningNumbers);
    }

    public static LottoService createLottoService(int lottoCount, String lastWinningNumbers) {
        return new LottoService(lottoCount, lastWinningNumbers);
    }

    public void calculatorLottoWinningCount() {
        List<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            lotto.calculatorLottoWinningCount(winnerLotto);
        }
    }

    public Lottos getLottos() {
        return lottos;
    }
}
