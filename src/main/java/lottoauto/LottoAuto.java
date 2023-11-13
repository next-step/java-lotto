package lottoauto;

import lottoauto.controller.LottoController;
import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.LottoShuffler;
import lottoauto.domain.aggregate.WinnerBoard;
import lottoauto.domain.lotto.Lottos;
import lottoauto.domain.lotto.LottosMaker;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lottos lottos = LottosMaker.makeLottoList(new LottoShuffler(), inputView.inputLottoBuyMoney());
        WinnerBoard winnerBoard = new WinnerBoard();
        Aggregator aggregator = new Aggregator();

        LottoController lottoController = new LottoController(aggregator, lottos, winnerBoard);

        outputView.printLottoListInfo(lottos);

        lottoController.checkWinnerLotto(inputView.inputWinningNumbers());
        outputView.printWinnerStatistics(winnerBoard);

        double earningRate = lottoController.calculateEarningRate();
        outputView.printEarningRate(earningRate);
    }
}
