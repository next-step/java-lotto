package lotto.cotroller;

import lotto.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Controller {

    public Controller() {
        int purchaseAmount = InputView.inputPrice();
        int purchaseNumber = PurchaseNumberCalculation.calculateNumberPurchase(purchaseAmount);

        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber, new LottoTicketCreation());
        ResultView.outputPrintPurchaseLottoTicket(lottoTickets);

        List<Integer> lastWeeksWinningNumbers = InputView.inputLastWeeksWinningNumbers();
        WinningCounts winningCounts = new WinningCounts()
                .calculateWinningCount(lottoTickets, lastWeeksWinningNumbers);

        WinningStatistic winningStatistic = new WinningStatistic(winningCounts);
        double rateOfReturn = RateOfReturn.calculateRateOfReturn(winningStatistic, purchaseAmount);

        ResultView.outputWinningStatistic(winningStatistic, rateOfReturn);
    }
}
