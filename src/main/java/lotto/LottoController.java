package lotto;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;
import lotto.domain.WinLotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoTicketBall ticketBall = new LottoTicketBall();
    private LottoTicketGenerator ticketGenerator = new LottoTicketGenerator(ticketBall);


    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoTicket> tickets = ticketGenerator.purchaseLotto(purchaseAmount);
        outputView.displayLottoTickets(tickets);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall();
        LottoResultManager lottoResultManager = new LottoResultManager(tickets,
            new WinLotto(winningNumbers, bonusNumber));
        outputView.displayWinning(lottoResultManager);
        outputView.displayWinningMoney(lottoResultManager, purchaseAmount);

    }


}
