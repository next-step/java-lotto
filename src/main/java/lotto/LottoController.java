package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    public static void run(LottoTicketCreatable lottoTicketCreatable) {
        int purchasePrice = InputView.inputPrice();

        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);

        LottoTickets lottoTickets = lottoTicketCreatable.createTickets(purchaseCount);
        OutputView.printTicketList(lottoTickets, purchasePrice);

        LottoTicket inputLastWeeksWinningNumbers = LottoTicket.newTicket(InputView.inputLastWeeksWinningNumbers());
        Number bonusNumber = Number.newNumber(InputView.inputBonusNumber());
        LastWinningNumbers lastWeeksWinningNumbers = LastWinningNumbers.newWinningNumbers(inputLastWeeksWinningNumbers, bonusNumber);

        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers);
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
