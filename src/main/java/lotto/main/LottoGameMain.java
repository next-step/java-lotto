package lotto.main;

import lotto.game.LottoGame;
import lotto.gameresult.GameResult;
import lotto.number.BonusNumber;
import lotto.number.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final int price = inputView.askUserToPay();
        LottoGame lottoGame = new LottoGame(price);

        resultView.showTicketsCounts(lottoGame);
        resultView.showEachTicketsLottoNumbers(lottoGame);

        List<Integer> winningNumbersOfLastWeek = inputView.askUserToEnterWinningNumbersOfLastWeek();
        BonusNumber bonusNumber = new BonusNumber(inputView.askUserBonusNumber());

        GameResult gameResult = new GameResult(lottoGame, WinningNumbers.valueOf(winningNumbersOfLastWeek), bonusNumber);
        resultView.showWinningRateReport(gameResult);
    }
}
