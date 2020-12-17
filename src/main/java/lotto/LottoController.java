package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    public void run() {
        int purchasePrice = InputView.inputPrice();

        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);

        LottoTickets lottoTickets = new LottoTicketCreation().createTickets(purchaseCount);
        OutputView.printTicketList(lottoTickets, purchasePrice);

        LastWinningNumbers lastWeeksWinningNumbers = LastWinningNumbers.newWinningNumbers(InputView.inputLastWeeksWinningNumbers());
        BonusNumber bonusNumber = BonusNumber.newNumber(InputView.inputBonusNumber());

        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers, bonusNumber);
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
