package lotto.cotroller;

import lotto.LottoTickets;
import lotto.PurchaseNumberCalculation;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Controller {

    public Controller() {
        int purchaseAmount = InputView.input();
        int purchaseNumber = PurchaseNumberCalculation.calculateNumberPurchase(purchaseAmount);

        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber);

        ResultView.output(lottoTickets);
    }
}
