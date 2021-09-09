package step5;

import step5.domain.*;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.Map;

public class LottoApp {
    public static void main(String[] args) {
        Integer purchaseAmount = InputView.requirePurchaseAmount();
        Integer numberOfManualLottoTicketPurchased = InputView.requireNumberOfManualLotto();
        int numberOfLottoTicketsPurchased = purchaseAmount / 1000;
        int numberOfAutoLottoTicketPurchased = numberOfLottoTicketsPurchased - numberOfManualLottoTicketPurchased;

        LottoTickets lottoTickets = new LottoTickets();
        buyLotto(numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased, lottoTickets);

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(InputView.requireLastWinningLottoNumber(), InputView.requireBonusBall());
        lottoTickets.match(winningLottoTicket);


        ResultView.printPurchaseLottoInfo(numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased);
        ResultView.printLottoNumberInfo(lottoTickets);
        ResultView.printResult(lottoTickets.lottoResult());
    }

    private static void buyLotto(Integer numberOfManualLottoTicketPurchased, int numberOfAutoLottoTicketPurchased, LottoTickets lottoTickets) {
        for (int i = 0; i < numberOfManualLottoTicketPurchased; i++) {
            lottoTickets.buyLottoManually(new ManualLottoTicket(InputView.requireManualLottoNumber()));
        }
        lottoTickets.buyLottoAutomatically(numberOfAutoLottoTicketPurchased);
    }
}
