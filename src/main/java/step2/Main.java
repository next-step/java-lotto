package step2;

import static step2.view.InputView.printPurchasePrice;
import static step2.view.OutputView.printLottoTicket;

import step2.model.LottoStore;
import step2.model.Payment;
import step2.model.PurchasedLottoTickets;

public class Main {
    public static void main(String[] args) {
        int purchasePrice = printPurchasePrice();

        PurchasedLottoTickets purchasedLottoTickets = LottoStore.sell(Payment.of(purchasePrice));

        printLottoTicket(purchasedLottoTickets);
    }
}
