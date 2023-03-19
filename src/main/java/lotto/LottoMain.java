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

        int[] winningNumbers1 = InputView.inputLastWeekWinningNumber();
        int bonusNumber = InputView.inputLastWeekBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(bonusNumber, winningNumbers1);
        WinningStatistics statistics = lottoGame.getStatistics(winningNumbers);
        ResultView.printLottoResult(statistics);
    }
}
