package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.LottoTicketsFactory;
import lotto.domain.ManualLottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());

        int manualCount = InputView.inputManualLottoCount();
        ManualLottos manualLottos = InputView.inputManualLottos(manualCount);

        LottoTickets tickets = LottoTicketsFactory.create(purchaseAmount, manualLottos);
        ResultView.printTicketCount(tickets);
        ResultView.printLottoTickets(tickets);

        Lotto winningLotto = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        WinningResult result = tickets.matchWith(winningNumbers);

        ResultView.printWinningStatistics(result);
        double profitRate = result.calculateProfitRate(purchaseAmount);
        ResultView.printProfitRate(profitRate);
    }
}
