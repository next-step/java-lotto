package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.view.TerminalInputView;
import lotto.view.TerminalOutputView;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        TerminalOutputView outputView = new TerminalOutputView();

        outputView.printPurchaseAmountGuide();
        int purchaseAmount = inputView.purchaseAmount();

        LottoPrice lottoPrice = new LottoPrice(purchaseAmount);
        int numberOfTicket = lottoPrice.numberOfTicket();

        Lotto lotto = new Lotto(numberOfTicket);
        outputView.printLottoTickets(lotto.myLottoTickets());
    }
}
