package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoGame;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoController {

    private final LottoView lottoView;

    public LottoController(final LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        int payment = lottoView.readPayment();
        int manualLottoCount = lottoView.readManualLottoCount();

        List<Lotto> manualLottos = readLottos(manualLottoCount);
        LottoGame lottoGame = new LottoGame(payment, manualLottos);

        lottoView.printLottoCount(lottoGame.getManualCount(), lottoGame.getRandomCount());
        lottoView.printLottos(lottoGame.getLottos());

        List<Integer> winningLotto = lottoView.readWinningLotto();
        int bonusBall = lottoView.readBonusBall();

        printResult(lottoGame, winningLotto, bonusBall);
    }

    private List<Lotto> readLottos(int manualLottoCount) {
        List<Lotto> lottos = lottoView.readManualLottos(manualLottoCount).stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        return lottos;
    }

    private void printResult(LottoGame lottoGame, List<Integer> winningLotto, int bonusBall) {
        LottoResult result = lottoGame.getResult(winningLotto, bonusBall);

        lottoView.printResults(result.getResult());
        lottoView.printProfitRate(lottoGame.getProfitRate(result));
    }
}
