package lotto.main;

import lotto.game.LottoGame;
import lotto.gameresult.GameResult;
import lotto.number.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final int price = inputView.askUsersToPay();
        List<Integer> winningNumbersOfLastWeek = inputView.askUserToEnterWinningNumbersOfLastWeek();

        LottoGame lottoGame = new LottoGame(price);
        resultView.showTicketsCounts(lottoGame);
        resultView.showEachTicketsLottoNumbers(lottoGame);

        GameResult expectedGameResult = new GameResult(lottoGame, WinningNumbers.getInstanceByInt(winningNumbersOfLastWeek));
        resultView.showWinningRateReport(expectedGameResult);
    }
}
