package lotto.cotroller;

import lotto.LottoTickets;
import lotto.PurchaseNumberCalculation;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Controller {

    public Controller() {
        int purchaseAmount = InputView.inputPrice();
        int purchaseNumber = PurchaseNumberCalculation.calculateNumberPurchase(purchaseAmount);

        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber);
        ResultView.output(lottoTickets);

        List<Integer> lastWeeksWinningNumbers = InputView.inputLastWeeksWinningNumbers();
    }
}
