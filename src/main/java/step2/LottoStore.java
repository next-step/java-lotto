package step2;

import step2.domain.ConfirmResults;
import step2.domain.LottoGame;
import step2.domain.LottoGames;
import step2.domain.PurchaseStandBy;
import step2.ui.DisplayHere;
import step2.ui.OrderHere;

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
