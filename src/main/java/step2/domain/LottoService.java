package step2.domain;

import step2.domain.model.Lotto.Lotto;
import step2.domain.model.Lotto.Lottos;
import step2.domain.strategy.lotto.LottoPolicyStrategy;

public class LottoService {
    private Lottos lottos;
    private Lotto WinningLotto;

    public LottoService(int lottoCount, String lastWinningNumbers) {
        this.lottos = new Lottos(lottoCount);
        this.WinningLotto = Lotto.fromWinningLotto(new LottoPolicyStrategy(), lastWinningNumbers);
    }

    public static LottoService of(int lottoCount, String lastWinningNumbers) {
        return new LottoService(lottoCount, lastWinningNumbers);
    }

    public void calculatorLottoWinningCount() {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.calculatorLottoWinningCount(WinningLotto);
        }
    }

    public Lottos getLottos() {
        return lottos;
    }
}
