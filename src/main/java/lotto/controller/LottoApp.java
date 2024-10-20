package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Winning;
import lotto.domain.WinningCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoTickets lottoTickets = InputView.getLottoTickets();
        ResultView.printTicketCount(lottoTickets.size());
        ResultView.printTickets(lottoTickets);

        LottoTicket winningNumbers = InputView.getWinningNumbers();
        LottoNumber bonusNumber = InputView.getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        List<Winning> winnings = lottoTickets.calculateWinningResults(lottoWinningNumbers);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);
        ResultView.printWinningResult(winningCalculator);
    }
}
