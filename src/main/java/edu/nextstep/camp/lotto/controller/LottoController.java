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

    public Lottos buyLottos() {
        int amount = lottoView.amountInput();

        Lottos lottos = lottoGame.buyLotto(amount);

        lottoView.buyLottoOutputView(amount, lottos);

        return lottos;
    }

    public void analysisLotto(Lottos lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또가 null 입니다.");
        }

        LastWinLotto lastWinLotto = lottoView.lastWinLottoInput();

        lottoView.lottoAnalysisOutputView(lottos.analysis(lastWinLotto));
    }
}
