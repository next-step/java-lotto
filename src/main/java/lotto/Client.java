package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTicketGenerator;
import lotto.view.InputView;

public class Client {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        LottoController lottoController = new LottoController(new LottoTicketGenerator());

        lottoController.createLottoTickets(purchaseAmount);
    }
}
