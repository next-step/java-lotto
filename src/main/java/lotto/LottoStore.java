package lotto;

import lotto.domain.*;
import lotto.ui.DisplayHere;
import lotto.ui.OrderHere;

public class LottoStore {

	private LottoStore() {}

	public static void main(String[] args) {
		OrderHere orderHere = new OrderHere();
		DisplayHere displayHere = new DisplayHere();

		PurchaseStandBy purchaseStandBy = orderHere.orderNewPurchasing();

		LottoGames purchasedGames = purchaseStandBy.purchase();

		displayHere.printPurchasedGames(purchasedGames);

		PrizeInfo lastWeekPrize = orderHere.receiveLastWeekPrize();

		ConfirmResults confirmResults = purchasedGames.confirmPrize(lastWeekPrize);

		displayHere.printPrizeStatistics(purchaseStandBy, confirmResults);

	}
}
