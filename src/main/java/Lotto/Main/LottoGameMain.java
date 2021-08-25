package Lotto.Main;

import Lotto.Game.LottoGame;
import Lotto.GameResult.ExpectedGameResult;
import Lotto.Number.WinningNumbers;
import Lotto.UI.InputView;
import Lotto.UI.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        final int price = InputView.askUserToPayForLottoTickets();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.shoowTicketsCounts(lottoGame);
        ResultView.showEachTicketsLottoNumbers(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.getWinningNumbersOfLastWeek());
        ExpectedGameResult expectedGameResult = new ExpectedGameResult(lottoGame, winningNumbers);
        ResultView.showNumberOfTicketsWinningPrize(expectedGameResult);
        ResultView.showProfitRateAndGain(expectedGameResult);
    }
}
