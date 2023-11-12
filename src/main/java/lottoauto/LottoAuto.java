package lottoauto;

import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.AggregatorMaker;
import lottoauto.domain.aggregate.LottoShuffler;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        AggregatorMaker aggregatorMaker = new AggregatorMaker(new LottoShuffler());
        Aggregator aggregator = aggregatorMaker.makeAggregator(inputView.inputLottoBuyMoney());

        outputView.printLottoListInfo(aggregator);

        aggregator.checkWinnerLotto(inputView.inputWinningNumbers());

        outputView.printWinnerStatistics(aggregator);
        outputView.printEarningRate(aggregator.calculateEarningRate());
    }
}
