package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoResultManager resultManager = new LottoResultManager();
    private LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();


    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoTicket> tickets = ticketGenerator.purchaseLotto(purchaseAmount);
        outputView.displayLottoTickets(tickets);
        Map<Integer, Integer> lottoResult = resultManager.calculateLottoResult(tickets,
                inputView.inputWinningNumbers());
        outputView.displayWinning(lottoResult);
        outputView.displayWinningMoney(
                resultManager.calculateReturnRate(lottoResult, purchaseAmount));
    }

}
