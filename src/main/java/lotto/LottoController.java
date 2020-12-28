package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoController {

    public static void run() {
        int purchasePrice = InputView.inputPrice();
        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);
        int manualPurchaseCount = InputView.inputManualPurchaseCount(purchaseCount);
        List<LottoTicket> manualLottoTicketList = InputView.inputManualLottoTicketList(manualPurchaseCount);

        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseCount, manualLottoTicketList);
        OutputView.printTicketList(lottoTickets, purchaseCount, manualPurchaseCount);

        LottoTicket inputLastWeeksWinningNumbers = LottoTicket.newTicket(InputView.inputLastWeeksWinningNumbers());
        Number bonusNumber = Number.newNumber(InputView.inputBonusNumber());
        LastWinningNumbers lastWeeksWinningNumbers = LastWinningNumbers.newWinningNumbers(inputLastWeeksWinningNumbers, bonusNumber);

        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers);
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
