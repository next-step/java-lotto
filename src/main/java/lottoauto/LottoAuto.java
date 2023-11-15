package lottoauto;

import lottoauto.domain.EarningRateCalculator;
import lottoauto.domain.lotto.LottoShuffler;
import lottoauto.domain.WinnerBoard;
import lottoauto.domain.lotto.Lottos;
import lottoauto.domain.lotto.LottosMaker;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lottos lottos = LottosMaker.makeLottoList(new LottoShuffler(), inputView.inputLottoBuyMoney());
        outputView.printLottoListInfo(lottos);

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(inputView.inputWinningNumbers());
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, lottos);
        outputView.printEarningRate(earningRate);
    }
}
