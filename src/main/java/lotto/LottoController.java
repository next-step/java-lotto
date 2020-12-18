package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    public static void run(LottoTicketCreatable lottoTicketCreatable) {
        int purchasePrice = InputView.inputPrice();

        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);

        LottoTickets lottoTickets = lottoTicketCreatable.createTickets(purchaseCount);
        OutputView.printTicketList(lottoTickets, purchasePrice);

        LastWinningNumbers lastWeeksWinningNumbers = LastWinningNumbers.newWinningNumbers(InputView.inputLastWeeksWinningNumbers());
        BonusNumber bonusNumber = BonusNumber.newNumber(InputView.inputBonusNumber());

        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers, bonusNumber);
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
