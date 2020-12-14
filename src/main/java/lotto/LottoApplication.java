package lotto;

import lotto.domain.LottoMessage;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerNumbers;
import lotto.domain.PurchaseTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPrice lottoPrice = new LottoPrice(InputView.askToUserPurchaseAmount(), InputView.askToUserPurchaseNumberOfManual());
		PurchaseTicket purchaseTicket = new PurchaseTicket(lottoPrice);

		OutputView.printPurchaseMessage(purchaseTicket.getPurchaseLottoSize());

		LottoTicket purchasedLottoTicket = LottoTicket.purchase(purchaseTicket);
		OutputView.printMessage(LottoMessage.purchasedTickets(purchasedLottoTicket));

		LottoWinnerNumbers lottoWinnerNumbers = LottoWinnerNumbers.ofUser(
			InputView.askToUserLastWeekWinnerNumber(),
			InputView.askToUserBonusNumber());
		LottoResult lottoResult = LottoResult.compareTicketAndWinner(purchasedLottoTicket, lottoWinnerNumbers);
		OutputView.printMessage(LottoMessage.winningStatistics(lottoResult));
		OutputView.printMessage(LottoMessage.totalProfit(lottoPrice, lottoResult));
	}
}
