package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;
import lottoGame.view.ResultView;

import java.util.List;

public class LottoGameController {
    private final InputParameter inputParameter;
    private final ShuffleStrategy shuffleStrategy;

    private final ResultView resultView;

    private final RankResult rankResult = new RankResult();
    private final Lottery lottery = new Lottery();


    public LottoGameController(InputParameter inputParameter, ShuffleStrategy shuffleStrategy, ResultView resultView) {
        this.inputParameter = inputParameter;
        this.shuffleStrategy = shuffleStrategy;
        this.resultView = resultView;

    }

    public void start() {
        lottery.create(inputParameter.getLotteryNum(), shuffleStrategy);
        resultView.printLottery(lottery);
        List<Integer> matchNumber = lottery.findMatchNumber(resultView.inputWinningNumer());
        rankResult.putResult(matchNumber);
        resultView.printStatistics(rankResult);
        resultView.printYield(rankResult.getYield(inputParameter.getAmount()));
    }

}
