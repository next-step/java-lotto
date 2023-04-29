package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void run() {
        int numberOfTickets = InputView.calculateNumberOfTicketsToBuy();
        LottoTickets lottoTickets = new LottoGenerator().generateLottoTickets(numberOfTickets);
        ResultView.printLottoTickets(lottoTickets);

        String winningNumbersString = InputView.inputWinningNumbers();

        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString);
        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics();
        double earningsRate = winningStatistics.calculateEarningsRate(numberOfTickets);

        ResultView.printLottoResult(winningStatistics, earningsRate);
    }
}

