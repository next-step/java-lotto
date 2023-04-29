package step3.domain;

import step3.domain.model.Lotto.Lotto;
import step3.domain.model.Lotto.Lottos;
import step3.domain.strategy.lotto.LottoPolicyStrategy;

public class LottoService {
    private Lottos lottos;

    public LottoService(int lottoCount) {
        this.lottos = new Lottos(lottoCount);
    }

    public static LottoService of(int lottoCount) {
        return new LottoService(lottoCount);
    }

    public static Lotto createWinningLotto(String lastWinningNumbers) {
        return Lotto.fromWinningLotto(new LottoPolicyStrategy(), lastWinningNumbers);
    }

    public void calculatorLottoWinning(Lotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.calculatorLottoWinning(winningLotto);
        }
    }

    public Lottos getLottos() {
        return lottos;
    }
}
