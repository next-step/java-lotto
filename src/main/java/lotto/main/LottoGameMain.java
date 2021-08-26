package lotto.main;

import lotto.game.LottoGame;
import lotto.gameresult.GameResult;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        final int price = InputView.askUserToPayForLottoTickets();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.showTicketsCounts(lottoGame);
        ResultView.showEachTicketsLottoNumbers(lottoGame);
        List<Integer> numbers = InputView.getWinningNumbersOfLastWeek();

        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.getInstanceByInt(numbers));
        GameResult expectedGameResult = new GameResult(lottoGame, winningNumbers);
        ResultView.showWinningRateReport(expectedGameResult);
    }
}
