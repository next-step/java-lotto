package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoCounter;
import lotto.domain.Lottos;
import lotto.domain.Purchase;
import lotto.domain.WinningLotto;
import lotto.service.WinningRankStatistics;

public class Main {
    public static void main(String[] args) {
        LottoCounter lottoCounter = LottoController.createLottoCounter();

        Lottos manualLottos = LottoController.getManualLottos(lottoCounter.getManualLottoCount());

        Lottos lottos = new Purchase(lottoCounter, manualLottos).drawLottos();

        LottoController.showLottosWithCount(lottos, lottoCounter);

        WinningLotto winningLotto = LottoController.createWinningLotto();

        WinningRankStatistics winningRankStatistics = LottoController.getWinningRankStatistics(lottos, winningLotto);

        LottoController.showResult(winningRankStatistics);
    }
}
