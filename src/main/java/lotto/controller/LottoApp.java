package lotto.controller;

import lotto.domain.LottoTicketMaker;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Winning;
import lotto.domain.WinningCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoTicketMaker lottoTicketMaker = InputView.getLottoTicketMaker();
        LottoTickets lottoTickets = lottoTicketMaker.createLottoTickets();
        ResultView.printTicketsInfo(lottoTickets);

        LottoWinningNumbers lottoWinningNumbers = InputView.getLottoWinningNumbers();
        List<Winning> winnings = lottoTickets.calculateWinningResults(lottoWinningNumbers);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);
        ResultView.printWinningResult(winningCalculator);
    }
}
