package lotto;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.collections.WinningNumbers;
import lotto.collections.WinningTicket;
import lotto.domain.LottoNumber;
import lotto.service.PurchaseService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class NextStepLottoApplication {

	public static void main(String[] args) {
		Money money = InputView.inputPurchaseMoney();
		LottoTickets lottoTickets = PurchaseService.purchase(money);
		OutputView.printNumberOfPurchasedTickets(lottoTickets);

		WinningNumbers winningNumbers = InputView.inputLastWeekWinningNumbers();
		LottoNumber bonusBall = InputView.inputBonusBall();
		WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusBall);

		LottoResult lottoResult = WinningService.getLottoResult(lottoTickets, winningTicket);
		OutputView.printResult(lottoResult, lottoTickets);
	}
}
