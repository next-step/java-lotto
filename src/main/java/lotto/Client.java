package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.value.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutView;

public class Client {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        LottoController lottoController = new LottoController(new LottoTicketGenerator());

        LottoTickets lottoTickets = lottoController.createLottoTickets(purchaseAmount);

        OutView.showLottoTickets(lottoTickets);
    }
}
