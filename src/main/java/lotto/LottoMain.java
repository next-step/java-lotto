package lotto;

import lotto.domain.WinningStatistics;
import lotto.domain.LottoGame;
import lotto.domain.LotteryNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoMain {
    public static void main(String[] args) {

        int buyMoney = InputView.inputBuyPrice();
        LottoGame lottoGame = new LottoGame(buyMoney);
        ResultView.printBuyCountForPrint(lottoGame);

        LotteryNumbers lotteryNumbers = new LotteryNumbers(InputView.inputLastWeekWinningNumber(), InputView.inputLastWeekBonusNumber());
        WinningStatistics statistics = lottoGame.getStatistics(lotteryNumbers);
        ResultView.printLottoResult(statistics);
    }




}
