package lottoauto;

import lottoauto.controller.LottoController;
import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.AggregatorMaker;
import lottoauto.domain.aggregate.LottoShuffler;
import lottoauto.domain.aggregate.WinnerBoard;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        AggregatorMaker aggregatorMaker = new AggregatorMaker(new LottoShuffler());
        Aggregator aggregator = aggregatorMaker.makeAggregator(inputView.inputLottoBuyMoney());

        LottoController lottoController = new LottoController(aggregator);

        outputView.printLottoListInfo(aggregator);

        WinnerBoard winnerBoard = lottoController.checkWinnerLotto(inputView.inputWinningNumbers());
        outputView.printWinnerStatistics(winnerBoard);

        double earningRate = lottoController.calculateEarningRate();
        outputView.printEarningRate(earningRate);
    }
}
