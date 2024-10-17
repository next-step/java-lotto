package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Winning;
import lotto.domain.WinningCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoTickets lottoTickets = InputView.getLottoTickets();
        LottoTicket winningNumbers = InputView.getWinningNumbers();
        List<Winning> winnings = lottoTickets.calculateWinningResults(winningNumbers);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);

        ResultView.printTicketCount(lottoTickets.size());
        ResultView.printTickets(lottoTickets);
        ResultView.printWinningResult(winningCalculator);
    }
}
