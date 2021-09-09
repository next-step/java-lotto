package step5;

import step5.domain.LottoTicket;
import step5.domain.LottoTickets;
import step5.domain.ManualLottoTicket;
import step5.view.InputView;

public class LottoApp {
    public static void main(String[] args) {
        Integer purchaseAmount = InputView.requirePurchaseAmount();
        int numberOfLottoTicketsPurchased = purchaseAmount / 1000; 
        Integer numberOfManualLottoTicketPurchased = InputView.requireNumberOfManualLotto();
        int numberOfAutoLottoTicketPurchased = numberOfLottoTicketsPurchased - numberOfManualLottoTicketPurchased;
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < numberOfManualLottoTicketPurchased; i++) {
            lottoTickets.buyLottoManually(new ManualLottoTicket(InputView.requireManualLottoNumber()));
        }

        lottoTickets.buyLottoAutomatically(numberOfAutoLottoTicketPurchased);
    }
}
