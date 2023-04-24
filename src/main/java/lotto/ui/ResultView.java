package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

public class ResultView {

	public static void printPurchaseCount(int purchaseCount) {
		System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
	}

	public static void printCurrentSituation(PurchasedLottos purchasedLottos) {
		for (Lotto lotto : purchasedLottos.getLottos()) {
			System.out.println(lotto.getSelectedNumbers());
		}
	}
}
