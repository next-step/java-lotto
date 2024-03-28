package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoResultManager resultManager = new LottoResultManager();
    private LottoTicketBall ticketBall = new LottoTicketBall();
    private LottoTicketGenerator ticketGenerator = new LottoTicketGenerator(ticketBall);


    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoTicket> tickets = ticketGenerator.purchaseLotto(purchaseAmount);
        outputView.displayLottoTickets(tickets);
        Map<LottoPrice, Integer> results = resultManager.calculateLottoResult(tickets,
            inputView.inputWinningNumbers(), inputView.inputBonusBall());
        outputView.displayWinning(results);
        outputView.displayWinningMoney(
            resultManager.calculateReturnRate(results, purchaseAmount));
    }

}
