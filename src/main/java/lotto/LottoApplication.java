package lotto;

import lotto.domain.LottoService;
import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.PurchaseAmount;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService service;

    public LottoApplication() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.service = new LottoService();
    }

    public void start() {
        try {
            PurchaseAmount amount = inputView.inputPurchaseAmount();
            List<LottoTicket> lottoTickets = service.purchaseTickets(amount);
            resultView.printTickets(lottoTickets);

            WinningLottoTicket winingLottoTicket =
                    new WinningLottoTicket(inputView.inputWinningNumbers(), inputView.inputBonusNumber());
            LottoGameResult result = service.draw(lottoTickets, winingLottoTicket);

            resultView.printResult(amount, result);
        } finally {
            inputView.close();
        }
    }

    public static void main(String[] args) {
        new LottoApplication().start();
    }
}
