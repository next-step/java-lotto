package lotto;

import java.util.List;
import lotto.domain.LottoTicketBall;
import lotto.domain.LottoTicketCollection;
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
        int manualLottoCount = inputView.inputManualLottoCount();
        List<List<Integer>> manualLottoNumbers = inputView.inputManualLottoNumber(manualLottoCount);
        LottoTicketCollection ticketCollection = ticketGenerator.purchaseLotto(purchaseAmount,
            manualLottoNumbers);
        outputView.displayLottoTickets(ticketCollection);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall();

        LottoResultManager lottoResultManager = new LottoResultManager(ticketCollection,
            new WinLotto(winningNumbers, bonusNumber));

        outputView.displayWinning(lottoResultManager);
        outputView.displayWinningMoney(lottoResultManager);

    }


}
