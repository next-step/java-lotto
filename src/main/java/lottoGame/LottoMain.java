package lottoGame;

import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.AutoShuffleStrategy;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottogame = new LottoGame(InputView.print());
        Lottery lottery = lottogame.start(new AutoShuffleStrategy());
        ResultView resultView = new ResultView(lottery);
        resultView.printLottery();
        RankResult rankResult = lottery.createRankResult(InputView.inputWinningNumer());
        resultView.printStatistics(rankResult);
    }
}
