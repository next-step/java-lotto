package lotto;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();

        int lottoCost = InputView.inputCost();
        int lottoCount = lottoSystem.calcLottoCount(lottoCost);

        List<Lotto> lottos = lottoSystem.makeLottoList(lottoSystem.lottoNumbersSetting(), lottoCount);

        ResultView.showLottoCount(lottoCount);
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
