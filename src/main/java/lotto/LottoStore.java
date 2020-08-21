package lotto;

import lotto.domain.ConfirmResults;
import lotto.domain.GameWinningCondition;
import lotto.domain.LottoGames;
import lotto.domain.PurchaseStandBy;
import lotto.ui.DisplayHere;
import lotto.ui.OrderHere;

import static lotto.constants.MessageConstant.NEW_LINE;

public class LottoStore {

	private LottoStore() {}

	public static void main(String[] args) {
		OrderHere orderHere = new OrderHere();
		DisplayHere displayHere = new DisplayHere();
		boolean result;
		do {
			 result = runProcess(orderHere, displayHere);
		} while (result);
	}

	private static boolean runProcess(OrderHere orderHere, DisplayHere displayHere) {
		try{
			PurchaseStandBy purchaseStandBy = orderHere.orderNewPurchasing();
			LottoGames purchasedGames = purchaseStandBy.purchase();
			displayHere.printPurchasedGames(purchaseStandBy, purchasedGames);
			GameWinningCondition lastWeekPrize = orderHere.receiveLastWeekPrize();
			ConfirmResults confirmResults = purchasedGames.confirmPrize(lastWeekPrize);
			displayHere.printPrizeStatistics(purchaseStandBy, confirmResults);
			return false;
		} catch (LottoException e) {
			displayHere.printErrorMessage(e.getMessage() + NEW_LINE);
			return true;
		}
	}
}
