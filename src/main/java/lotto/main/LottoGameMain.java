package lotto.main;

import lotto.game.LottoGame;
import lotto.gameresult.GameResult;
import lotto.number.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        final int price = InputView.askUserToPayForLottoTickets();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.showTicketsCounts(lottoGame);
        ResultView.showEachTicketsLottoNumbers(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.getWinningNumbersOfLastWeek());
        GameResult expectedGameResult = new GameResult(lottoGame, winningNumbers);
        ResultView.showNumberOfTicketsWinningPrize(expectedGameResult);
        ResultView.showProfitRateAndGain(expectedGameResult);
    }
}
