package lotto;

public class LottoApplication {

	public static void main(String[] args) {
		LottoPrice lottoPrice = new LottoPrice(InputView.askToUserPurchaseAmount());
		OutputView.printPurchaseMessage(lottoPrice.purchaseTicketAmount());

		LottoTicket purchasedLottoTicket = LottoTicket.purchase(lottoPrice.purchaseTicketAmount());
		OutputView.printMessage(LottoMessage.purchasedTickets(purchasedLottoTicket));

		LottoWinnerNumbers lottoWinnerNumbers = LottoWinnerNumbers.ofUser(InputView.askToUserLastWeekWinnerNumber());
		LottoResults lottoResults = LottoResults.compareTicketAndWinner(purchasedLottoTicket, lottoWinnerNumbers);
		OutputView.printMessage(LottoMessage.winningStatistics(lottoResults));
		OutputView.printMessage(LottoMessage.totalProfit(lottoPrice.purchaseCost(), lottoResults));
	}
}
