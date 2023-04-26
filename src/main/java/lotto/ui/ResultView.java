package lotto.ui;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.PrizeSituation;

public class ResultView {

	public static void printPurchasedCount(int purchaseCount) {
		System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
	}

	public static void printCurrentSituation(PurchasedLottos purchasedLottos) {
		for (Lotto lotto : purchasedLottos.getLottos()) {
			System.out.println(lotto.getSelectedNumbers());
		}
	}

	public static void printPrizeSituations(List<PrizeSituation> prizeSituations) {
		System.out.println("당첨 통계");
		System.out.println("---------");
	}
}
