package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoTickets lottoTickets = InputView.getLottoTickets();
        LottoTicket winningNumbers = InputView.getWinningNumbers();
        List<Integer> matchCounts = lottoTickets.matchCount(winningNumbers);
        WinningCalculator winningCalculator = new WinningCalculator(matchCounts);

        ResultView.printTicketCount(lottoTickets.size());
        ResultView.printTickets(lottoTickets);
        ResultView.printWinningResult(winningCalculator);
    }
}
