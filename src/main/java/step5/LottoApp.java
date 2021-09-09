package step5;

import step5.domain.*;
import step5.view.InputView;
import step5.view.ResultView;

public class LottoApp {
    public static void main(String[] args) {
        Integer purchaseAmount = InputView.requirePurchaseAmount();
        Integer numberOfManualLottoTicketPurchased = InputView.requireNumberOfManualLotto();
        int numberOfLottoTicketsPurchased = purchaseAmount / 1000;
        int numberOfAutoLottoTicketPurchased = numberOfLottoTicketsPurchased - numberOfManualLottoTicketPurchased;

        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < numberOfManualLottoTicketPurchased; i++) {
            lottoTickets.buyLottoManually(new ManualLottoTicket(InputView.requireManualLottoNumber()));
        }
        lottoTickets.buyLottoAutomatically(numberOfAutoLottoTicketPurchased);

        ResultView.printPurchaseLottoInfo(numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased);
        ResultView.printLottoNumberInfo(lottoTickets);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(InputView.requireLastWinningLottoNumber());
        BonusBall bonusBall = new BonusBall(InputView.requireBonusBall());

        lottoTickets.match(winningLottoTicket, bonusBall);
    }
}
