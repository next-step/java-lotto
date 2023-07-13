package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoService;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(final LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        int payment = lottoView.readPayment();

        LottoService lottoService = new LottoService(payment);

        lottoView.printLottoCount(lottoService.getCount());
        lottoView.printLottos(lottoService.getLottos());

        List<Integer> winningLotto = lottoView.readWinningLotto();
        int bonusBall = lottoView.readBonusBall();

        LottoResult result = lottoService.getResult(winningLotto, bonusBall);

        lottoView.printResults(result.getResult());
        lottoView.printProfitRate(result.getProfit());
    }
}
