package lotto.controller;

import lotto.domain.ProfitRate;
import lotto.domain.ResultRecord;
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

        ResultRecord result = lottoService.getResult(winningLotto, bonusBall);
        lottoView.printResults(result.getResult());

        ProfitRate profitRate = lottoService.getProfitRage(result.getProfit());
        lottoView.printProfitRate(profitRate.calculateRate());
    }
}
