package lotto.controller;

import lotto.domain.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(final LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        String payment = lottoView.readPayment();
        LottoService lottoService = new LottoService(payment);

        lottoView.printLottoCount(lottoService.getCount());
        lottoView.printLottos(lottoService.getLottos());

        String winningLotto = lottoView.readWinningLotto();
        String bonusBall = lottoView.readBonusBall();

        lottoView.printResults(lottoService.getResult(winningLotto, bonusBall));
        lottoView.printProfitRate(lottoService.getProfitRate());
    }
}
