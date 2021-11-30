package lotto;

import lotto.controller.LottoController;
import lotto.application.LottoTicketGenerator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutView;

public class Client {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        LottoController lottoController = new LottoController(new LottoTicketGenerator());

        LottoTickets lottoTickets = lottoController.createLottoTickets(purchaseAmount);
        OutView.showLottoTickets(lottoTickets);

        String winningNumbers = InputView.getWinningNumbers();

        LottoResult lottoResult = lottoController.createLottoResult(winningNumbers, lottoTickets);

        OutView.showLottoResult(lottoResult);
    }
}
