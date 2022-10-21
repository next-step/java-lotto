package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.AutoShuffleStrategy;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputParameter inputParmeter = InputView.print();
        LottoGame lottogame = new LottoGame(inputParmeter);
        Lottery lottery = lottogame.start(new AutoShuffleStrategy());
        ResultView resultView = new ResultView(lottery);
        resultView.printLottery();
        RankResult rankResult = lottery.createRankResult(InputView.inputWinningNumer(), new RankResult());
        resultView.printStatistics(rankResult,inputParmeter);
    }
}
