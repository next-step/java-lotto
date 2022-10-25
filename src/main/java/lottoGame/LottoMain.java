package lottoGame;

import lottoGame.dto.ResultParameter;
import lottoGame.model.strategy.AutoShuffleStrategy;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.createLotto(InputView.print(), new AutoShuffleStrategy());
        ResultView.printLottery(lottoGame.getResult());
        RankResult rankResult = lottoGame.fillInRankResult(InputView.inputWinningNumer(), new RankResult());
        ResultView.printStatistics(rankResult);
    }
}
