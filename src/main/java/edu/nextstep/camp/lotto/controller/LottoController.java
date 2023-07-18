package edu.nextstep.camp.lotto.controller;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.LottoFactory;
import edu.nextstep.camp.lotto.domain.LottoGame;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.view.LottoView;

public class LottoController {

    private final LottoGame lottoGame;
    private final LottoView lottoView;

    public LottoController(LottoFactory lottoFactory, LottoView lottoView) {
        this.lottoGame = new LottoGame(lottoFactory);
        this.lottoView = lottoView;
    }

    public int numberOfLottoPurchases() {
        return lottoGame.numberOfLottoPurchases(lottoView.amountInput());
    }

    public Lottos buyLottos(int lottoCount) {
        int manualCount = lottoView.manualLottoCountInput();

        validationManualCount(lottoCount, manualCount);

        Lottos lottos = lottoGame.buyLotto(lottoCount - manualCount, lottoView.manualLottoInput(manualCount));

        lottoView.buyLottoOutputView(manualCount, lottos);

        return lottos;
    }

    public void analysisLotto(Lottos lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또가 null 입니다.");
        }

        LastWinLotto lastWinLotto = lottoView.lastWinLottoInput();

        lottoView.lottoAnalysisOutputView(lottos.analysis(lastWinLotto));
    }

    private void validationManualCount(int lottoCount, int manualCount) {
        if (manualCount < 0 || manualCount > lottoCount) {
            throw new IllegalArgumentException("수동 로또는 0~" + lottoCount + "개 구입 가능 합니다.");
        }
    }
}
