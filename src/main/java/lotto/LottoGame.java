package lotto;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        List<Lotto> lottos;
        LottoSystem lottoSystem = new LottoSystem();

        int lottoCost = InputView.inputCost();
        int lottoCount = lottoSystem.calcLottoCount(lottoCost);
        int manualLottoCount = InputView.inputManualLottoCount();

        lottos = lottoSystem.generateAllLottos(InputView.inputManualLottos(manualLottoCount), (lottoCount - manualLottoCount));

        ResultView.moveLine();
        ResultView.showLottoCount(lottoCount, manualLottoCount);
        ResultView.showLottos(lottos);
        ResultView.moveLine();

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto(), InputView.inputWinningBonus());
        LottoResult result = new LottoResult();

        for(Lotto lotto : lottos) {
            result.setRankingStatus(winningLotto.getRankByMatchingLotto(lotto));
        }

        ResultView.moveLine();
        ResultView.showStatistics(result, lottoCost);
    }

}
