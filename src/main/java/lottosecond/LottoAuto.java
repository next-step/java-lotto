package lottosecond;

import lottosecond.domain.EarningRateCalculator;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.lotto.LottoShuffler;
import lottosecond.domain.lotto.Lottos;
import lottosecond.domain.lotto.LottosMaker;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

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
