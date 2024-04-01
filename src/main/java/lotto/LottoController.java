package lotto;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;
import lotto.domain.WinLotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoTicketGenerator ticketGenerator = new LottoTicketGenerator(
        new LottoTicketBall());


    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoTicket> tickets = ticketGenerator.purchaseLotto(purchaseAmount);
        outputView.displayLottoTickets(tickets);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall();
        LottoResultManager lottoResultManager = new LottoResultManager(tickets,
            new WinLotto(winningNumbers, bonusNumber));
        outputView.displayWinning(lottoResultManager);
        outputView.displayWinningMoney(lottoResultManager);

    }


}
