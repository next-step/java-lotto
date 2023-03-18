package lotto;

import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.domain.LottoGame;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoMain {
    public static void main(String[] args) {

        int buyMoney = InputView.inputBuyPrice();
        LottoGame lottoGame = new LottoGame(new Money(buyMoney));
        ResultView.printBuyCountForPrint(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputLastWeekBonusNumber(), InputView.inputLastWeekWinningNumber());
        WinningStatistics statistics = lottoGame.getStatistics(winningNumbers);
        ResultView.printLottoResult(statistics);
    }
}
