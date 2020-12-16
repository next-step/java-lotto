package lotto;

import lotto.domain.LottoMessage;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerNumbers;
import lotto.domain.LottoTicketStore;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPrice lottoPrice = new LottoPrice(InputView.askToUserPurchaseAmount(), InputView.askToUserPurchaseNumberOfManual());
		List<String> userInputs = InputView.enterPurchaseManuallyNumber(lottoPrice.getManualCount());
		OutputView.printPurchaseMessage(lottoPrice.getManualCount(), lottoPrice.getAutoCount());

		LottoTicket purchasedLottoTicket = LottoTicketStore.purchaseLottoTicket(lottoPrice, userInputs);
		OutputView.printMessage(LottoMessage.purchasedTickets(purchasedLottoTicket));

		LottoWinnerNumbers lottoWinnerNumbers = LottoWinnerNumbers.ofUser(
			InputView.askToUserLastWeekWinnerNumber(),
			InputView.askToUserBonusNumber());
		LottoResult lottoResult = LottoResult.compareTicketAndWinner(purchasedLottoTicket, lottoWinnerNumbers);

		OutputView.printMessage("당첨 통계\n---------");
		OutputView.printMessage(LottoMessage.winningStatistics(lottoResult));
		OutputView.printMessage(LottoMessage.totalProfit(lottoPrice, lottoResult));
	}
}
