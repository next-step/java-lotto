package lottery;

import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int purchaseAmount = InputView.payAmount();

        LottoTicketSeller seller = new LottoTicketSeller();
        ResultView.printLottoTickets(seller.purchaseRandomGames(purchaseAmount));
    }

}
