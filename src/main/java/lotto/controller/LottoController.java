package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.ProfitRate;
import lotto.domain.ResultRecord;
import lotto.domain.LottoGame;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(final LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        int payment = lottoView.readPayment();
        int manualLottoCount = lottoView.readManualLottoCount();

        List<Lotto> lottos = lottoView.readManualLottos(manualLottoCount).stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        LottoGame lottoGame = new LottoGame(payment, manualLottoCount, lottos);

        lottoView.printLottoCount(lottoGame.getManualCount(), lottoGame.getAutomaticCount());
        lottoView.printLottos(lottoGame.getLottos());

        List<Integer> winningLotto = lottoView.readWinningLotto();
        int bonusBall = lottoView.readBonusBall();

        ResultRecord result = lottoGame.getResult(winningLotto, bonusBall);
        lottoView.printResults(result.getResult());

        ProfitRate profitRate = lottoGame.getProfitRate(result);
        lottoView.printProfitRate(profitRate.getProfitRate());
    }
}
