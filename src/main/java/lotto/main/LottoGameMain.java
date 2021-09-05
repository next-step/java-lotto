package lotto.main;

import lotto.game.LottoGame;
import lotto.gameresult.GameResult;
import lotto.number.BonusNumber;
import lotto.number.WinningNumbers;
import lotto.ticket.LottoTicket;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final int price = inputView.askToPay();

        final int manualTicketCount = inputView.askManualTicketCount();
        final List<LottoTicket> manualTickets = inputView.askLottoNumbers(manualTicketCount);

        LottoGame lottoGame = new LottoGame(price, manualTickets);

        resultView.showTicketCount(lottoGame.manualTicketCount(), lottoGame.autoTicketCount());
        resultView.showTickets(lottoGame.lottoTickets());

        List<Integer> winningNumbersOfLastWeek = inputView.askWinningNumbers();
        BonusNumber bonusNumber = new BonusNumber(inputView.askBonusNumber());

        GameResult gameResult = new GameResult(lottoGame, WinningNumbers.valueOf(winningNumbersOfLastWeek), bonusNumber);
        resultView.showWinningRate(gameResult);
    }
}
