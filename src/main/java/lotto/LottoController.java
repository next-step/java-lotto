package lotto;

import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoTicket> tickets = lottoService.purchaseLotto(purchaseAmount);
        outputView.displayLottoTickets(tickets);
        outputView.displayWinning(
                lottoService.checkWinningResult(tickets, inputView.inputWinningNumbers()),
                purchaseAmount);
    }

}
