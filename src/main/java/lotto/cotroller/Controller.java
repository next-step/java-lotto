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
        List<Integer> winningCounts = WiningStatistic.winningCounts(lottoTickets, lastWeeksWinningNumbers);
        double rateOfReturn = RateOfReturn.calculateRateOfReturn(winningCounts, purchaseAmount);

        ResultView.outputWinningStatistic(winningCounts, rateOfReturn);
    }
}
