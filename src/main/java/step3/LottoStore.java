package step3;

import step3.domain.ConfirmResults;
import step3.domain.LottoGame;
import step3.domain.LottoGames;
import step3.domain.PurchaseStandBy;
import step3.ui.DisplayHere;
import step3.ui.OrderHere;

public class LottoStore {

	private LottoStore() {}

	public static void main(String[] args) {
		OrderHere orderHere = new OrderHere();
		DisplayHere displayHere = new DisplayHere();

		PurchaseStandBy purchaseStandBy = orderHere.orderNewPurchasing();

		LottoGames purchasedGames = purchaseStandBy.purchase();

		displayHere.printPurchasedGames(purchasedGames);

		LottoGame lastWeekPrize = orderHere.receiveLastWeekPrize();

		ConfirmResults confirmResults = purchasedGames.confirmPrize(lastWeekPrize);

		displayHere.printPrizeStatistics(purchaseStandBy, confirmResults);

	}
}
