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
        int price = InputView.getPrice();
        int manualCount = InputView.getManualLottoCount();
        List<String> manualNumbers = InputView.getManualLottoNumbers(manualCount);

        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker(price, manualNumbers);
        LottoTickets lottoTickets = lottoTicketMaker.createLottoTickets();

        ResultView.printTicketInfo(lottoTickets);

        LottoWinningNumbers lottoWinningNumbers = InputView.getLottoWinningNumbers();
        List<Winning> winnings = lottoTickets.calculateWinningResults(lottoWinningNumbers);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);
        ResultView.printWinningResult(winningCalculator);
    }
}
